SUMMARY = "Creates a new user with a secure hashed password"
DESCRIPTION = "Adds a user 'jetsonnano01' with a pre-hashed password to the system."
LICENSE = "MIT"

inherit extrausers

DEPENDS += "openssl-native"

EXTRA_USERS_PARAMS = "\
    groupadd -r sudo; \
    useradd -u 1200 -d /home/jetsonnano01 -p '\$6\$5qyAHTOM.Pk2kDrz\$qmICDt2cmJJdJa3FVS0ZGVcsD0w0KXJUTSC7SreeVUvuYws.aeaWo7NPEsqbX3kS7V5l0SCn/Sl16rbpJJVZk1' -s /bin/sh jetsonnano01; \
    usermod -aG sudo jetsonnano01; \
"
