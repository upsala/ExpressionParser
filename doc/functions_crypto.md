## Crypto-Functions
- [CRC32](#CRC32): Calculates the crc32 of the given values
- [MD5](#MD5): Calculates the md5 of the given values
- [SHA1](#SHA1): Calculates the sha1 of the given values
- [SHA256](#SHA256): Calculates the sha256 of the given values
- [UUID](#UUID): Generates a v4-UUID

### CRC32
    Syntax: CRC32(str, ...)
Calculates the crc32 of the given values 

    CRC32('test') => 'd87f7e0c'

### MD5
    Syntax: MD5(str, ...)
Calculates the md5 of the given values

    MD5("test") => '098f6bcd4621d373cade4e832627b4f6'
    MD5("test", "2") => 'ad0234829205b9033196ba818f7a872b'

### SHA1
    Syntax: SHA1(str, ...)
Calculates the sha1 of the given values 

    SHA1("test") => 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3'
    SHA1("test", "2") => '109f4b3c50d7b0df729d299bc6f8e9ef9066971f'

### SHA256
    Syntax: SHA256(str, ...)
Calculates the sha256 of the given values 

    SHA256("test") => '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08'
    SHA256("test", "2") => '60303ae22b998861bce3b28f33eec1be758a213c86c93c076dbe9f558c11c752'

### UUID
    Syntax: UUID()
Generates a v4-UUID                       

    UUID() => '6066f9a8-b1d5-446a-a175-755df86fcbb4'
