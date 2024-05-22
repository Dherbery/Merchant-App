package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.reanimated.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class SharedTransitionManager {
    private final AnimationsManager mAnimationsManager;
    private NativeMethodsHolder mNativeMethodsHolder;
    private View mTransitionContainer;
    private final List<View> mAddedSharedViews = new ArrayList();
    private final Map<Integer, View> mSharedTransitionParent = new HashMap();
    private final Map<Integer, Integer> mSharedTransitionInParentIndex = new HashMap();
    private final Map<Integer, Snapshot> mSnapshotRegistry = new HashMap();
    private final Map<Integer, View> mCurrentSharedTransitionViews = new HashMap();
    private final List<View> mRemovedSharedViews = new ArrayList();
    private final Set<Integer> mViewTagsToHide = new HashSet();
    private final Map<Integer, Integer> mDisableCleaningForViewTag = new HashMap();
    private List<SharedElement> mSharedElements = new ArrayList();
    private final Map<Integer, SharedElement> mSharedElementsLookup = new HashMap();
    private final List<SharedElement> mSharedElementsWithProgress = new ArrayList();
    private final List<SharedElement> mSharedElementsWithAnimation = new ArrayList();
    private final Set<View> mReattachedViews = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface TreeVisitor {
        void run(View view);
    }

    public SharedTransitionManager(AnimationsManager animationsManager) {
        this.mAnimationsManager = animationsManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAboutNewView(View view) {
        this.mAddedSharedViews.add(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAboutRemovedView(View view) {
        this.mRemovedSharedViews.add(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public View getTransitioningView(int i) {
        return this.mCurrentSharedTransitionViews.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void screenDidLayout() {
        tryStartSharedTransitionForViews(this.mAddedSharedViews, true);
        this.mAddedSharedViews.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void viewDidLayout(View view) {
        maybeRestartAnimationWithNewLayout(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewsRemoval(int[] iArr) {
        if (iArr == null) {
            return;
        }
        visitTreeForTags(iArr, new SnapshotTreeVisitor());
        if (this.mRemovedSharedViews.size() > 0) {
            if (!tryStartSharedTransitionForViews(this.mRemovedSharedViews, false)) {
                this.mRemovedSharedViews.clear();
            }
            visitTreeForTags(iArr, new ConfigCleanerTreeVisitor());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doSnapshotForTopScreenViews(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                visitNativeTreeAndMakeSnapshot(((ViewGroup) childAt).getChildAt(0));
            } else {
                Log.e("[Reanimated]", "Unable to recognize screen on stack.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
    }

    private void maybeRestartAnimationWithNewLayout(View view) {
        View view2 = this.mCurrentSharedTransitionViews.get(Integer.valueOf(view.getId()));
        if (view2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SharedElement sharedElement : this.mSharedElements) {
            if (sharedElement.targetView == view2) {
                arrayList.add(sharedElement);
                View view3 = sharedElement.sourceView;
                View view4 = sharedElement.targetView;
                Snapshot snapshot = new Snapshot(view3);
                Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(view4.getId()));
                Snapshot snapshot3 = new Snapshot(view4);
                int i = (snapshot2.originX - snapshot2.originXByParent) + snapshot3.originX;
                int i2 = (snapshot2.originY - snapshot2.originYByParent) + snapshot3.originY;
                snapshot2.originX = i;
                snapshot2.originY = i2;
                snapshot2.globalOriginX = i;
                snapshot2.globalOriginY = i2;
                snapshot2.originXByParent = snapshot3.originXByParent;
                snapshot2.originYByParent = snapshot3.originYByParent;
                snapshot2.height = snapshot3.height;
                snapshot2.width = snapshot3.width;
                sharedElement.sourceViewSnapshot = snapshot;
                sharedElement.targetViewSnapshot = snapshot2;
                disableCleaningForViewTag(view3.getId());
                disableCleaningForViewTag(view4.getId());
            }
        }
        startSharedTransition(arrayList, 4);
    }

    private boolean tryStartSharedTransitionForViews(List<View> list, boolean z) {
        if (list.isEmpty()) {
            return false;
        }
        sortViewsByTags(list);
        List<SharedElement> sharedElementsForCurrentTransition = getSharedElementsForCurrentTransition(list, z);
        if (sharedElementsForCurrentTransition.isEmpty()) {
            return false;
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(sharedElementsForCurrentTransition);
        orderByAnimationTypes(sharedElementsForCurrentTransition);
        startSharedTransition(this.mSharedElementsWithAnimation, 4);
        startSharedTransition(this.mSharedElementsWithProgress, 5);
        return true;
    }

    private void sortViewsByTags(List<View> list) {
        Collections.sort(list, new Comparator() { // from class: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = Integer.compare(((View) obj2).getId(), ((View) obj).getId());
                return compare;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x013b, code lost:
    
        if ((!r20 ? !(r1.getId() == r13.getId() && r2.getId() == r14.getId()) : !(r2.getId() == r13.getId() && r1.getId() == r14.getId())) == false) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.swmansion.reanimated.layoutReanimation.SharedElement> getSharedElementsForCurrentTransition(java.util.List<android.view.View> r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.getSharedElementsForCurrentTransition(java.util.List, boolean):java.util.List");
    }

    private void setupTransitionContainer() {
        Activity currentActivity;
        if (this.mTransitionContainer == null) {
            this.mTransitionContainer = new ReactViewGroup(this.mAnimationsManager.getContext());
        }
        if (this.mTransitionContainer.getParent() != null || (currentActivity = this.mAnimationsManager.getContext().getCurrentActivity()) == null) {
            return;
        }
        ((ViewGroup) currentActivity.getWindow().getDecorView().getRootView()).addView(this.mTransitionContainer);
        this.mTransitionContainer.bringToFront();
    }

    private void reparentSharedViewsForCurrentTransition(List<SharedElement> list) {
        Iterator<SharedElement> it = list.iterator();
        while (it.hasNext()) {
            View view = it.next().sourceView;
            if (!this.mSharedTransitionParent.containsKey(Integer.valueOf(view.getId()))) {
                this.mSharedTransitionParent.put(Integer.valueOf(view.getId()), (View) view.getParent());
                this.mSharedTransitionInParentIndex.put(Integer.valueOf(view.getId()), Integer.valueOf(((ViewGroup) view.getParent()).indexOfChild(view)));
                ((ViewGroup) view.getParent()).removeView(view);
                ((ViewGroup) this.mTransitionContainer).addView(view);
                this.mReattachedViews.add(view);
            }
        }
    }

    private void startSharedTransition(List<SharedElement> list, int i) {
        for (SharedElement sharedElement : list) {
            View view = sharedElement.sourceView;
            view.setVisibility(0);
            startSharedAnimationForView(view, sharedElement.sourceViewSnapshot, sharedElement.targetViewSnapshot, i);
            sharedElement.targetView.setVisibility(4);
        }
    }

    private void startSharedAnimationForView(View view, Snapshot snapshot, Snapshot snapshot2, int i) {
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        HashMap<String, Object> prepareDataForAnimationWorklet = this.mAnimationsManager.prepareDataForAnimationWorklet(snapshot.toCurrentMap(), false, true);
        HashMap<String, Object> hashMap = new HashMap<>(this.mAnimationsManager.prepareDataForAnimationWorklet(targetMap, true, true));
        hashMap.putAll(prepareDataForAnimationWorklet);
        this.mNativeMethodsHolder.startAnimation(view.getId(), i, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finishSharedAnimation(int i) {
        final ViewParent parent;
        if (this.mDisableCleaningForViewTag.containsKey(Integer.valueOf(i))) {
            enableCleaningForViewTag(i);
            return;
        }
        SharedElement sharedElement = this.mSharedElementsLookup.get(Integer.valueOf(i));
        if (sharedElement == null) {
            return;
        }
        this.mSharedElementsLookup.remove(Integer.valueOf(i));
        View view = sharedElement.sourceView;
        if (this.mReattachedViews.contains(view)) {
            this.mReattachedViews.remove(view);
            int id = view.getId();
            ((ViewGroup) this.mTransitionContainer).removeView(view);
            View view2 = this.mSharedTransitionParent.get(Integer.valueOf(id));
            int intValue = this.mSharedTransitionInParentIndex.get(Integer.valueOf(id)).intValue();
            ViewGroup viewGroup = (ViewGroup) view2;
            if (intValue <= viewGroup.getChildCount()) {
                viewGroup.addView(view, intValue);
            } else {
                viewGroup.addView(view);
            }
            Snapshot snapshot = this.mSnapshotRegistry.get(Integer.valueOf(id));
            if (snapshot != null) {
                int i2 = snapshot.originY;
                if (findStack(view) == null) {
                    snapshot.originY = snapshot.originYByParent;
                }
                HashMap<String, Object> basicMap = snapshot.toBasicMap();
                HashMap hashMap = new HashMap();
                for (String str : basicMap.keySet()) {
                    Object obj = basicMap.get(str);
                    if (str.equals(Snapshot.TRANSFORM_MATRIX)) {
                        hashMap.put(str, obj);
                    } else {
                        hashMap.put(str, Double.valueOf(PixelUtil.toDIPFromPixel(Utils.convertToFloat(obj))));
                    }
                }
                this.mAnimationsManager.progressLayoutAnimation(id, hashMap, true);
                snapshot.originY = i2;
            }
            if (this.mViewTagsToHide.contains(Integer.valueOf(i))) {
                view.setVisibility(4);
            }
            this.mCurrentSharedTransitionViews.remove(Integer.valueOf(sharedElement.targetView.getId()));
            this.mCurrentSharedTransitionViews.remove(Integer.valueOf(id));
            this.mSharedTransitionParent.remove(Integer.valueOf(id));
            this.mSharedTransitionInParentIndex.remove(Integer.valueOf(id));
        }
        sharedElement.targetView.setVisibility(0);
        if (this.mRemovedSharedViews.contains(view)) {
            this.mRemovedSharedViews.remove(view);
            this.mSnapshotRegistry.remove(Integer.valueOf(view.getId()));
            this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        }
        if (this.mReattachedViews.isEmpty()) {
            View view3 = this.mTransitionContainer;
            if (view3 != null && (parent = view3.getParent()) != null) {
                this.mTransitionContainer.post(new Runnable() { // from class: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SharedTransitionManager.this.lambda$finishSharedAnimation$1(parent);
                    }
                });
            }
            this.mSharedElements.clear();
            this.mSharedElementsWithProgress.clear();
            this.mSharedElementsWithAnimation.clear();
            this.mViewTagsToHide.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finishSharedAnimation$1(ViewParent viewParent) {
        if (this.mReattachedViews.size() > 0) {
            return;
        }
        ((ViewGroup) viewParent).removeView(this.mTransitionContainer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private View findScreen(View view) {
        for (ViewParent viewParent = view.getParent(); viewParent != 0; viewParent = viewParent.getParent()) {
            if (viewParent.getClass().getSimpleName().equals("Screen")) {
                return (View) viewParent;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private View findStack(View view) {
        for (ViewParent viewParent = view.getParent(); viewParent != 0; viewParent = viewParent.getParent()) {
            if (viewParent.getClass().getSimpleName().equals("ScreenStack")) {
                return (View) viewParent;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeSnapshot(View view) {
        this.mSnapshotRegistry.put(Integer.valueOf(view.getId()), new Snapshot(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class SnapshotTreeVisitor implements TreeVisitor {
        SnapshotTreeVisitor() {
        }

        @Override // com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.TreeVisitor
        public void run(View view) {
            if (SharedTransitionManager.this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                SharedTransitionManager.this.mRemovedSharedViews.add(view);
                SharedTransitionManager.this.makeSnapshot(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class ConfigCleanerTreeVisitor implements TreeVisitor {
        ConfigCleanerTreeVisitor() {
        }

        @Override // com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.TreeVisitor
        public void run(View view) {
            SharedTransitionManager.this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        }
    }

    protected void visitTreeForTags(int[] iArr, TreeVisitor treeVisitor) {
        if (iArr == null) {
            return;
        }
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        for (int i : iArr) {
            visitTree(reanimatedNativeHierarchyManager.resolveView(i), treeVisitor);
        }
    }

    private void visitTree(View view, TreeVisitor treeVisitor) {
        int id = view.getId();
        if (id == -1) {
            return;
        }
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        try {
            treeVisitor.run(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                ViewManager resolveViewManager = reanimatedNativeHierarchyManager.resolveViewManager(id);
                ViewGroupManager viewGroupManager = resolveViewManager instanceof ViewGroupManager ? (ViewGroupManager) resolveViewManager : null;
                if (viewGroupManager == null) {
                    return;
                }
                for (int i = 0; i < viewGroupManager.getChildCount((ViewGroupManager) viewGroup); i++) {
                    visitTree(viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i), treeVisitor);
                }
            }
        } catch (IllegalViewOperationException unused) {
        }
    }

    void visitNativeTreeAndMakeSnapshot(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                makeSnapshot(view);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                visitNativeTreeAndMakeSnapshot(viewGroup.getChildAt(i));
            }
        }
    }

    private void clearAllSharedConfigsForView(View view) {
        int id = view.getId();
        this.mSnapshotRegistry.remove(Integer.valueOf(id));
        this.mNativeMethodsHolder.clearAnimationConfig(id);
    }

    private void disableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num != null) {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), 1);
        }
    }

    private void enableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num == null) {
            return;
        }
        if (num.intValue() == 1) {
            this.mDisableCleaningForViewTag.remove(Integer.valueOf(i));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    void orderByAnimationTypes(List<SharedElement> list) {
        this.mSharedElementsWithProgress.clear();
        this.mSharedElementsWithAnimation.clear();
        for (SharedElement sharedElement : list) {
            if (this.mAnimationsManager.hasAnimationForTag(sharedElement.sourceView.getId(), 5)) {
                this.mSharedElementsWithProgress.add(sharedElement);
            } else {
                this.mSharedElementsWithAnimation.add(sharedElement);
            }
        }
    }
}
