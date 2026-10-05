class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        var exact = new HashSet<String>();
        var capitWise = new HashMap<String, String>();
        var vowelWise = new HashMap<String, String>();
        var res = new String[queries.length];

        for (var word: wordlist) {
            exact.add(word);
            capitWise.putIfAbsent(word.toLowerCase(), word);
            vowelWise.putIfAbsent(devowel(word), word);
        }

        for (int i = 0; i < queries.length; i++) {
            var query = queries[i];

            if (exact.contains(query)) res[i] = query;
            else if (capitWise.containsKey(query.toLowerCase())) res[i] = capitWise.get(query.toLowerCase());
            else if (vowelWise.containsKey(devowel(query))) res[i] = vowelWise.get(devowel(query));
            else res[i] = "";
        }

        return res;
    }

    public String devowel(String str) {
        var res = new StringBuilder();

        for(var c: str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) res.append('*');
            else res.append(c);
        }

        return res.toString();
    }
}