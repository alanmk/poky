#!/bin/sh

echo "Setting up SSH and user permissions..."

# Set SSH key permissions
chown -R jetsonnano01:jetsonnano01 /home/jetsonnano01/.ssh
chmod 700 /home/jetsonnano01/.ssh
chmod 600 /home/jetsonnano01/.ssh/authorized_keys

# Set sudoers permissions
chmod 440 /etc/sudoers.d/jetsonnano01

# Enable SSH service
systemctl enable sshd
systemctl restart sshd
