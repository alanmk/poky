SUMMARY = "Add a user with a pre-hashed password"
DESCRIPTION = "This recipe creates a user and assigns a secure hashed password"

inherit extrausers

# Replace the hashed password below with your generated hash
EXTRA_USERS_PARAMS = "\
    useradd -m -p '\$6\$GVnaXoPXrui3MGZd\$WcZBKao1jeTyk7VSEbYlLaOcyseUIP3FgcyxBET5GPF4iYbO239UNkVJXZWutRQEt8wszLxOU/k34F8kJIN5P/' jetsonnano01; \
    usermod -a -G sudo jetsonnano01; \
"
