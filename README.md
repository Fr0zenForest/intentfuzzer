# intentfuzzer
     模糊测试（Fuzzing），是一种通过向目标系统提供非预期的输入并监视异常结果来发现软件漏洞的方法。这是一种随机或半随机的测试方法，与Monkey等随机测试工具有异曲同工之妙，只是其关注点不同。
二 模糊测试的执行过程

   1.测试工具通过随机或是半随机的方式生成大量数据；
   2.测试工具将生成的数据发送给被测试的系统（输入）；
   3.测试工具检测被测系统的状态（如是否能够响应，响应是否正确等）；
   4.根据被测系统的状态判断是否存在潜在的安全漏洞

三 工具 IntentFuzzer

   1 工具简介
  这个工具是针对Intent的Fuzzer。它通常可以发现能够导致系统崩溃的bug，部分安全漏洞，以及设备、应用程序或者是定制平台的运行中的问题。该工具能够针对一个简单组件或者是所有安装组件进行fuzz测试。它也适用于BroadcastReceiver，但针对Service只有较少的覆盖，Service通常更加广泛地应用Binder接口而不是针对IPC的Intent。原版的工具只能针对一个Activity进行fuzz测试，一次不能针对所有的Activity进行测试。另外，也能应用这个接口来启动Instrumentation，虽然列出了ContentProvider，但是它们不是一个基于Intent的IPC机制，因此并不能应用该工具进行fuzz测试。MindMac在此基础上进行了一些修改，使其能够针对一个应用的一个简单组件或者是所有组件进行fuzz测试，同时具有区分系统应用和非系统应用的能力。MindMac修改后的版本仅针对Activity、BroadcastReceiver、Service。

  2 原理
     列举出系统上所有公开的、能够从应用获取到的Activity、BroadcastReceiver、Service、Instrumentation、ContentProvider。工具将通过Intent尝试启动所有可以获取到的组件，从而触发某些难以发掘的漏洞。触发一般有两类漏洞，一类是拒绝服务，一类的权限提升。拒绝服务危害性比较低，更多的只是影响应用服务质量；而权限提升将使得没有该权限的应用可以通过Intent触发拥有该权限的应用，从而帮助其完成越权行为。如果该工具能够轻易从外部启动特定应用的内部组件，尤其是有较高权限的组件时，很可能在此处发现漏洞。

  3 功能
    对某个组件或某个应用的某类组件发起Fuzz，分为
   Null Fuzz：Intent中不携带参数
   SerializeFuzz：Intent中不携带参数携带序列化对象参数
 然后尝试使用该Intent启动Activity、BroadcastReceiver、Service。     
    

   例如：百度APP, 分别选择 Null Fuzz ALL 和 Serialize Fuzz All 进行测试

