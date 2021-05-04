/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dslul.openboard.inputmethod.latin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class DeviceProtectedUtils {

    private static Context deviceProtectedContext;

    public static Context getContext(final Context context) {
        if (deviceProtectedContext != null) {
            return deviceProtectedContext;
        }
        deviceProtectedContext = context.isDeviceProtectedStorage()
                ? context : context.createDeviceProtectedStorageContext();
        return deviceProtectedContext;
    }

    public static SharedPreferences getSharedPreferences(final Context context) {
        return PreferenceManager.getDefaultSharedPreferences(getContext(context));
    }

    private DeviceProtectedUtils() {
        // This utility class is not publicly instantiable.
    }
}
