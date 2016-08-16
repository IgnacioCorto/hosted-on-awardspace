..\qemu -L ..\\. -cdrom dslcd2.iso -boot d -net nic,model=ne2k_pci,macaddr=00:00:00:00:00:02 -net socket,connect=localhost:1234
pause