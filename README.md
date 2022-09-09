# A blog article about Adapting My app for foldable phones

### My Android App description

<p> In this android application, it will take input an <strong>Ethereum Blockchain Public address </strong> and it will show the <strong>balance</strong>
of the address. Fetching balance is the minimum requirement of the task. I can show more information in the application like nonce, transaction details, 
send transaction. </p> <br>

<strong> How to adapt my application for a foldable device in steps : </strong> <br>

<p> Foldable technology for mobile is a groundbreaking experience not only for users but also for developers. The presence of many form factors like immersive 
display, app continuity, Flex mode and UX optimization challenge developers to think outside of the box to adapt to this technology.</p> <br>

<strong> Large screen optimization </strong> <br>

<p> Samsung foldable devices have two different physical screens: the cover display and the main display. As the cover display is much smaller than the
main display, large screen optimization is one of the key areas of designing UX for foldable devices. In a nutshell, my app can utilize the extra space
  in the main display by showing more information. Just having a different UI design with the same information can do the trick of optimization as well. </p>
  
To implement this scenario Developers have to create a new directory named <strong>layout-sw600dp</strong> under the res directory and then create an xml
file named <strong>activity_main. </strong> <br><br>

<strong> Flex mode optimization </strong> <br>

<p> In Galaxy Z series devices, Samsung introduced a new mode called Flex mode. This mode allows users to use apps while the book-like phone is partially
   folded. Creative design can really make your app stand out from others in Flex mode. </p> <br>
   
<p>Using Google’s new Jetpack library, WindowManager, you can detect the current posture of a Galaxy Z series device and update
  the UI accordingly by following these steps: </p>
  
 <strong>Step 1:</strong> Add the dependencies in the <strong>build.gradle.</strong> <br>
```
implementation "androidx.window:window:1.0.0-alpha01"
```
 
  <strong>Step 2:</strong> Define a <strong>WindowManager</strong> instance. <br>
  
```
val windowManager = WindowManager(this, null)
```


   <strong> Step 3:</strong> Register the <strong>DeviceState</strong> change listener. The listener notices changes in the device state 
          (for example CLOSED, OPENED, HALF_OPENED). <br>
          <strong> Code : </strong> <br>
```
windowManager.registerDeviceStateChangeCallback( 
mainThreadExecutor /* Executor */, 
callback /* Consumer<DeviceState> */
)
```
  
  <strong> Step 4:</strong> Write a callback function to check <strong>deviceState.posture</strong> to get the current posture of the device. If the posture is
  <strong>POSTURE_HALF_OPENED </strong>, the app UI gets updated for Flex mode. <br><br>
          <strong> Code : </strong> <br>
  ```
   val callback = Consumer<DeviceState> { deviceState ->
  if (deviceState.posture == DeviceState.POSTURE_HALF_OPENED) {
    // Display is folded, show Split UX
  } else {
    // Display is not folded, show Full Screen UX
  }
}
  ```
  
#### App continuity

<p> While folding and unfolding the device, the app must prevent data loss thus ensuring its continuity. This is achievable by using
  the onSaveInstanceState() method. First, save the data to retain the current state with <strong>onSaveInstanceState().</strong> </p> <br><br>
  
  
  ```
  @Override
public void onSaveInstanceState(Bundle savedInstanceState)
{
    //Save the current state
}
  ```
<p> Then, restore the data in the <strong>onCreate()</strong> function.</p>

```
@Override
protected void onCreate(Bundle savedInstanceState)
{
    if (savedInstanceState != null) {
        //restore the previous state
    }
}
```

<p> Thus we can adapt our app for foldable phones. 

<strong> Reference </strong> <br>

<a href="https://developer.samsung.com/sdp/blog/en-us/2021/09/14/adapt-your-app-to-foldable-devices-for-an-optimal-user-experience"> 
    Reference </a>


