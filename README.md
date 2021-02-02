# YASAN Helper: Android Persian
[![](https://jitpack.io/v/yasandev/yasan-helper-android-persian.svg)](https://jitpack.io/#yasandev/yasan-helper-android-persian) [![Build Status](https://travis-ci.com/yasandev/yasan-helper-android-persian.svg?branch=main)](https://travis-ci.com/yasandev/yasan-helper-android-persian) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/6ccea925d07d44d380a623a10e38ad0a)](https://www.codacy.com/gh/yasandev/yasan-helper-android-persian/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=yasandev/yasan-helper-android-persian&amp;utm_campaign=Badge_Grade)

A really light & simple Android library with just two functions & two extension functions to help you convert English numbers in strings into Persian numbers and vice versa. I have plans to add more helpful features soon.

## Usage
Persian Number Helper:
```kotlin
"123".toPersian() // == "۱۲٣"

"۱۲٣".toEnglish() // == "123"

PersianHelper.convertNumbersToEnglish("123") // == "۱۲٣"

PersianHelper.convertNumbersToEnglish("۱۲٣") // == "123"
```

Persian View Helper:
```kotlin
activity.forceRTL() 

activity.forceLTR() 

PersianViewHelper.forceRTL(activity)

PersianViewHelper.forceLTR(activity)
```

## Including in your project
This library is available via JitPack, so getting it as simple as adding it as a dependency, like this:

1.  Add JitPack repository to your project `build.gradle` file:
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
2.  Add the dependency to your module `build.gradle` file:
```gradle
dependencies {
    implementation 'com.github.yasandev:yasan-helper-android-persian:{latest version}'
}
```

You can also use `{branch name}-SNAPSHOT` to get the snapshot builds.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[GPL-3.0](https://www.gnu.org/licenses/gpl-3.0.txt)
