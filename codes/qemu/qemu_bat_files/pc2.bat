..\qemu.exe -L ..\\. -hda linux2.img -net nic,model=ne2k_isa,macaddr=00:00:00:00:00:02 -net socket,connect=localhost:1234
rem pause