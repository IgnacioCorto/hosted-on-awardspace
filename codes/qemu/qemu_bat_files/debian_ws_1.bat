rem ne2k_pci, ne2k_isa, rtl8139, pcnet, // smc91c111, lance
..\qemu -L ..\\. -hda debian-hdd-1.img -boot c -net nic,vlan=1,macaddr=00:00:00:00:00:11,model=ne2k_pci -net socket,vlan=1,listen=localhost:5678
rem pause