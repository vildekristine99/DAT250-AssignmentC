## IoT Device for the DAT250 project

Running the API on localhost?
- Turn off CORS

Crossplatform for Android, iOS and Web

Web:
- flutter config --enable-web
- flutter run -d chrome

Android:
- flutter run -d android

iOS:
- flutter run -d ios

If these commands results in an error like:
- No devices found with name or matching id

The you gotta specify the id for the device:
- flutter devices
- find the id of the device in the list
- flutter run -d "device-id"