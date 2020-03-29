package misc_topics.design_patterns;

/**
 * Simple class to demonstrate the builder pattern for a function
 */
public class BuilderPattern {
    private String result;

    public BuilderPattern(String input1, String input2, String input3) {
        result = input1 + input2 + input3;
    }

    public String getResult() {
        return result;
    }

    public static void main(String[] args) {
        BuilderPattern c = new BuilderPattern
                .BuilderFunc()
                .function1("My ")
                .function2("name ")
                .function3(" Ketan")
                .build();
        System.out.println(c.getResult());
    }

    public static class BuilderFunc {
        private String input1;
        private String input2;
        private String input3;

        public BuilderFunc() {
        }

        public BuilderFunc function1(String input1) {
            this.input1 = input1;
            return this;
        }

        public BuilderFunc function2(String input2) {
            this.input2 = input2;
            return this;
        }

        public BuilderFunc function3(String input3) {
            this.input3 = input3;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(input1, input2, input3);
        }

    }

}
