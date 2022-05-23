class User:
    def __init__(self, userid, username, email, passwd_hash):
        self.userid = userid
        self.username = username
        self.email = email
        self.passwd_hash = passwd_hash
