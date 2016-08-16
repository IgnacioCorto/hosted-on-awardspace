..\qemu -L ..\\. -hda debian-hdd-2.img -boot c -net nic,vlan=1,model=ne2k_pci,macaddr=00:00:00:00:00:12 -net socket,vlan=1,connect=localhost:5678
rem pause