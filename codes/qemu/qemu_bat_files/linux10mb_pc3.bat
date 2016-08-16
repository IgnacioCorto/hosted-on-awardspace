..\qemu.exe -L ..\\. -hda linux3.img -net nic,model=ne2k_isa,macaddr=00:00:00:00:00:33 -net socket,connect=localhost:5678
rem pause