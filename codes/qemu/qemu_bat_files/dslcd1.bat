..\qemu -L ..\\. -cdrom dslcd1.iso -boot d -net nic,model=ne2k_pci,macaddr=00:00:00:00:00:01 -net socket,listen=localhost:1234
rem pause