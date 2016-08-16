..\qemu.exe -L ..\\. -hda linux1.img -net nic,model=ne2k_isa,macaddr=00:00:00:00:00:01 -net tap,ifname=tap1 -net socket,listen=localhost:1234
rem pause