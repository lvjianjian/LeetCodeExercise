/**
 * Created by zhongjianlv on 18-3-19.
 * <p>
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Encode_and_Decode_TinyURL_535 {

    private String last = null;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        last = longUrl.substring(longUrl.length() - 1, longUrl.length());
        return longUrl.substring(0, longUrl.length() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl + last;
    }
}

