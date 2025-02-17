#!/bin/sh
USERNAME="jetsonnano01"

# Create user with home directory and shell
useradd -m -s /bin/bash $USERNAME

# Add user to sudo group
usermod -aG sudo $USERNAME

# Set correct permissions
mkdir -p /home/$USERNAME/.ssh
chmod 700 /home/$USERNAME/.ssh
chown -R $USERNAME:$USERNAME /home/$USERNAME
