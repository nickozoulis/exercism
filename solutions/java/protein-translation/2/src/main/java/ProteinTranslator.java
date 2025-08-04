import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {
    private static Map<String, String> codons;
    private List<String> translations;
    public ProteinTranslator() {
        translations = new ArrayList<>();

        codons = new HashMap<>();
        codons.put("AUG", "Methionine");
        codons.put("UUU", "Phenylalanine");
        codons.put("UUC", "Phenylalanine");
        codons.put("UUA", "Leucine");
        codons.put("UUG", "Leucine");
        codons.put("UCU", "Serine");
        codons.put("UCC", "Serine");
        codons.put("UCA", "Serine");
        codons.put("UCG", "Serine");
        codons.put("UAU", "Tyrosine");
        codons.put("UAC", "Tyrosine");
        codons.put("UGU", "Cysteine");
        codons.put("UGC", "Cysteine");
        codons.put("UGG", "Tryptophan");
        codons.put("UAA", "STOP");
        codons.put("UAG", "STOP");
        codons.put("UGA", "STOP");
    }

    List<String> translate(String rnaSequence) {

        try {
            for (int i = 0; i < rnaSequence.length(); i += 3) {
                final var str = "" + rnaSequence.charAt(i) + rnaSequence.charAt(i + 1) + rnaSequence.charAt(i + 2);

                final var codon = codons.get(str);

                if (codon.equals("STOP")) return translations;

                translations.add(codons.get(str));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid codon");
        }

        return translations;
    }
}
