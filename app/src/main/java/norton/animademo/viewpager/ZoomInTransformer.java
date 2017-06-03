/*
 * Copyright 2014 Toxic Bakery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package norton.animademo.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

public class ZoomInTransformer implements ViewPager.PageTransformer{

	@Override
	public void transformPage(View view, float position) {
		final float width = view.getWidth();

		view.setRotationX(0);
		view.setRotationY(0);
		view.setRotation(0);
		view.setScaleX(1);
		view.setScaleY(1);
		view.setPivotX(0);
		view.setPivotY(0);
		view.setTranslationY(0);
		view.setTranslationX(-width * position);

		final float scale = position < 0 ? position + 1f : Math.abs(1f - position);
		view.setScaleX(scale);
		view.setScaleY(scale);
		view.setPivotX(view.getWidth() * 0.5f);
		view.setPivotY(view.getHeight() * 0.5f);
		view.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f)); //不可见View
	}
}
