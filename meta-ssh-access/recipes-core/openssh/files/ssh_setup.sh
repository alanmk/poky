#!/bin/sh

echo "Setting up SSH and user permissions..."

# Ensure SSH directory and permissions
mkdir -p /home/jetsonnano01/.ssh
chown -R jetsonnano01:jetsonnano01 /home/jetsonnano01/.ssh
chmod 700 /home/jetsonnano01/.ssh
chmod 600 /home/jetsonnano01/.ssh/authorized_keys

# Ensure sudoers permissions
chmod 440 /etc/sudoers.d/jetsonnano01

# Enable and restart SSH service
systemctl enable sshd
systemctl restart sshd

echo "SSH setup completed."
