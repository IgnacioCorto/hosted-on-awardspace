..\qemu.exe -L ..\\. -hda linux1.img -net nic,model=ne2k_isa,macaddr=00:00:00:00:00:01 -net socket,listen=localhost:1234
rem pause