# UTMDemo
# 集成步骤

```java
maven { url 'http://nexus.rhinox.cn/repository/maven-public/'}
```

```java
implementation 'com.boniu.tracker:tracker:1.0.0@aar'
    implementation "com.google.code.gson:gson:2.8.2"
    implementation "com.squareup.okhttp3:okhttp:3.3.1"
    implementation "com.squareup.retrofit2:retrofit:2.2.0"
    implementation("com.squareup.retrofit2:converter-gson:2.2.0")
    { exclude group: 'com.squareup.okhttp3' exclude group: 'com.google.code.gson' }
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.2.0")
    { exclude group: 'com.squareup.okhttp3' }
    implementation "io.reactivex.rxjava2:rxjava:2.1.13"
    implementation("io.reactivex.rxjava2:rxandroid:2.0.2")
    { exclude module: 'rxjava' }
    implementation("com.squareup.okhttp3:logging-interceptor:3.3.1")
    { exclude group: 'com.android.support' exclude group: 'com.squareup.okhttp3' }
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.2.51"
    implementation "org.jetbrains.anko:anko-sqlite:0.10.5"
    implementation 'com.scottyab:secure-preferences-lib:0.1.7'
```

# 初始化 

使项⽬的 Application 继承接⼝ ITrackerContext ， 并在 onCreate ⽅法中进⾏初始化

应用名用包名，替换"."为"_" .需要在最前面加入

“bn_” 代表博牛app

```java
public class MyApp extends Application implements ITrackerContext {


    @Override
    public void onCreate() {
        super.onCreate();
        //设置应⽤渠道名，⼀般定义在AndroidManifest.xml中
        Tracker.INSTANCE.channelId = "mkbd"; //设置你的渠道
        //设置应⽤名，可以⽤应⽤唯⼀标识ID，也可以任意⾃定义
        Tracker.INSTANCE.projectName = "bn_" + BuildConfig.APPLICATION_ID.replace(".", "_");
        //上报模式，分为4种，具体参⻅下⽂
        Tracker.INSTANCE.setMode(TrackerMode.DEBUG_TRACK);
        //进⾏初始化
        Tracker.INSTANCE.initialize(this);
    }
}
```

# 上报模式

**DEBUG_ONLY**：仅在 Logcat 中打印⽇志，不上传数据。建议仅在调试阶段使⽤该模式。 

**DEBUG_TRACK**：在 Logcat 中打印⽇志，并且即时上传数据。建议在开发及测试阶段使⽤该模式。 

**RELEASE**：不在 Logcat 中打印⽇志，每10条记录尝试上传数据。在发⾏版本中使⽤该模式。 

**DISABLE**：禁⽤上报。设置该模式时，所有的上报相关⽅法都失效。如果想要重新⽣效，需要重新初始 

化。

## 上报用户id

需要手动上传用户id

接入时请联系后台 通过后台接口获取 `dataid`

```java
Map<String, Object> map = new HashMap<>();
map.put("dataid", "");
Tracker.INSTANCE.trackEvent("user.dataid", map);
```

## 广告展示成功埋点

广告展示成功后需要手动埋点 `广告类型 csj - 穿山甲 ylh - 优量汇 zhike - 直客`

接入的是搏牛广告sdk 可在代理中 获取广告类型 type

开屏广告

```java
Map<String, Object> map = new HashMap<>();
            map.put("type", type);
            Tracker.INSTANCE.trackEvent("event.splashAd", map);
```

激励视频

```java
Map<String, Object> map = new HashMap<>();
                        map.put("type", type);
                        Tracker.INSTANCE.trackEvent("event.rewardedVideoAd", map);
```

