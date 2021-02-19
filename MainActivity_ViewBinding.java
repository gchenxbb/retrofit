// Generated code from Butter Knife. Do not modify!
package com.pa.butterknife;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2130968596;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_hello_butter, "field 'tvHelloButter' and method 'onViewClicked'");
    target.tvHelloButter = Utils.castView(view, R.id.tv_hello_butter, "field 'tvHelloButter'", TextView.class);
    view2130968596 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.butter = res.getString(R.string.str_hi_butterknife);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvHelloButter = null;

    view2130968596.setOnClickListener(null);
    view2130968596 = null;
  }
}
