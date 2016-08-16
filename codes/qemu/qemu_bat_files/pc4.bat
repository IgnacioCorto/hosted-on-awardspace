..\qemu.exe -L ..\\. -hda linux4.img -net nic,model=ne2k_isa,macaddr=00:00:00:00:00:04 -net socket,connect=localhost:1234
rem pause