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
- make short alias for your specific needs in `.bashrc_aliases` file in ~ dir
- while this alias works fine in regular terminal
- this doesnt work in `alt+f2` i.e., non interactive shell
- for this create a shell script in `/bin/<your_script>`
- put your invoke command and actual command to run in back quotes
  - for e.g., ~/bin/sonybt.sh
    ````sh
    #!/bin/bash
    c `bluetoothctl <<<"connect 90:7A:58:24:6D:0B"`
    d `bluetoothctl <<<"disconnect 90:7A:58:24:6D:0B"`  - 
    ````
  - now you can enter `sonybt.sh c` or `sonybt.sh d` in `alt+f2`

# references
- find more detailed references at
  - [Configuring Bluetooth devices with bluetoothctl
](http://www.linux-magazine.com/Issues/2017/197/Command-Line-bluetoothctl)