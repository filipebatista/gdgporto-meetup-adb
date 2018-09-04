
# GDG Porto Android Sessions
## [Meetup #4](https://www.meetup.com/pt-BR/GDG-Porto/events/253780128/) - *ADB (Android Debug Bridge) - how can it help you*

Summary of the [adb](https://developer.android.com/studio/command-line/adb) commands used in the talk:

 - [List attached devices](#list-attached-devices)
 - [Install APK's](#install-apks)
 - [Uninstall APK’s](#uninstall-apks)
 - [List installed applications](#list-installed-applications)
 - [Get APK Path](#get-apk-file-path)
 - [Pull APK](#pull-an-apk)
 - [Dumpsys](#dumpsys)
 - [Find receivers by Intent Action](#find-receivers-by-intent-action)
 - [Send broadcast Intent](#send-broadcast-intent)
 - [See scheduled alarms](#see-scheduled-alarms)
---
#### List attached devices
```bash
adb devices
```

### Install APK's
```bash
adb install [-r] apk_to_install
```
---
### Uninstall APK’s
```bash
adb uninstall package
```
---
### List installed applications

##### All applications

```bash
adb shell pm list packages
```

##### Third party applications
```bash
adb shell pm list packages -3
```

##### Installed system applications with installer name
```bash
adb shell pm list packages -s -i
```
---
### Get APK file path 

##### Method #1
```bash
adb shell pm list packages -f
```

##### Method #2
```bash
adb shell pm path package
```

---

### Pull an APK
```bash
adb pull remote_path  local_path
```
---
### dumpsys

##### All Services
```bash
adb shell dumpsys
```
##### Activity top
```bash
adb shell dumpsys activity top
```
---
### Find receivers by Intent Action
```bash
adb shell cmd package query-receivers [--brief] –a intent_action
```
---

### Send broadcast Intent
```bash
adb shell am broadcast –a intent_action [--es] extra_key  extra_string_value  –p package
```

##### Example with demo_app
```bash
adb shell am broadcast -p com.filipebaptista.gdgportomeetup -a com.filipebaptista.gdgportomeetup.ACTION_HELLO 
```
```bash
adb shell am broadcast -p com.filipebaptista.gdgportomeetup -a com.filipebaptista.gdgportomeetup.ACTION_HELLO_WITH_EXTRA \
\ --es extra_name Filipe
```

### See scheduled alarms ###
```bash
adb shell dumpsys alarm
```