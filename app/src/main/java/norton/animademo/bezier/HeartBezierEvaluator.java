/*
 * Copyright (C) 2015, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package norton.animademo.bezier;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class HeartBezierEvaluator implements TypeEvaluator<PointF> {


    private PointF pointF1;
    private PointF pointF2;
    public HeartBezierEvaluator(PointF pointF1, PointF pointF2){
        this.pointF1 = pointF1;
        this.pointF2 = pointF2;
    }
    @Override
    public PointF evaluate(float t, PointF startValue,
                           PointF endValue) {

        // 三阶Bezier公式 。。

        float tLeft = 1.0f - t;
        PointF point = new PointF();

        point.x = tLeft * tLeft * tLeft * (startValue.x)
                + 3 * tLeft * tLeft * t * (pointF1.x)
                + 3 * tLeft * t * t * (pointF2.x)
                + t * t * t * (endValue.x);

        point.y = tLeft * tLeft * tLeft * (startValue.y)
                + 3 * tLeft * tLeft * t * (pointF1.y)
                + 3 * tLeft * t * t * (pointF2.y)
                + t * t * t * (endValue.y);
        return point;
    }
}
