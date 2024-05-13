// Generated by view binder compiler. Do not edit!
package com.hcl.hclpaybay.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hcl.hclpaybay.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FragmentContainerView fcvActivityMain;

  @NonNull
  public final ConstraintLayout root;

  @NonNull
  public final ToolbarBinding toolbarMain;

  @NonNull
  public final TextView tvStatusActivityMain;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView,
      @NonNull FragmentContainerView fcvActivityMain, @NonNull ConstraintLayout root,
      @NonNull ToolbarBinding toolbarMain, @NonNull TextView tvStatusActivityMain) {
    this.rootView = rootView;
    this.fcvActivityMain = fcvActivityMain;
    this.root = root;
    this.toolbarMain = toolbarMain;
    this.tvStatusActivityMain = tvStatusActivityMain;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fcv_activity_main;
      FragmentContainerView fcvActivityMain = ViewBindings.findChildViewById(rootView, id);
      if (fcvActivityMain == null) {
        break missingId;
      }

      ConstraintLayout root = (ConstraintLayout) rootView;

      id = R.id.toolbarMain;
      View toolbarMain = ViewBindings.findChildViewById(rootView, id);
      if (toolbarMain == null) {
        break missingId;
      }
      ToolbarBinding binding_toolbarMain = ToolbarBinding.bind(toolbarMain);

      id = R.id.tvStatus_activity_main;
      TextView tvStatusActivityMain = ViewBindings.findChildViewById(rootView, id);
      if (tvStatusActivityMain == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, fcvActivityMain, root,
          binding_toolbarMain, tvStatusActivityMain);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}