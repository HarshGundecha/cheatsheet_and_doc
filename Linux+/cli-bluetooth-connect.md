- [ubuntu cli bluetooth connect](#ubuntu-cli-bluetooth-connect)
- [th3 h4ck](#th3-h4ck)
- [references](#references)

# ubuntu cli bluetooth connect
- the tool **bluetoothctl** should be there pre-installed in ubuntu.
- `bluetoothctl <<<"connect <YOUR_DEVICE_MAC_HERE>"`
- e.g, for my BT headset
- `bluetoothctl <<<"connect 90:7A:58:24:6D:0B"`
- use following to disconnext
- bluetoothctl <<<"disconnect 90:7A:58:24:6D:0B"

# th3 h4ck
- make short alias for your specific needs then hit 'alt+f2' for run command
- shoot the alias and boooom, done for the day.

# references
- find more detailed references at
  - [Configuring Bluetooth devices with bluetoothctl
](http://www.linux-magazine.com/Issues/2017/197/Command-Line-bluetoothctl)