    private static class OpenExchangeRates {

        private String Uri;
        private final String ApiKey;

        public OpenExchangeRates(String apiKey) {
            this.ApiKey = apiKey;
        }

        public OpenExchangeRates Latest() {
            Uri = ("https://openexchangerates.org/api/latest.json?app_id=" + ApiKey + "&prettyprint=true&show_alternative=true");
            return this;
        }

        public OpenExchangeRates Historical(Date date) {
            Uri = ("https://openexchangerates.org/api/historical/" + new SimpleDateFormat("yyyy-MM-dd").format(date) + ".json?app_id=" + ApiKey + "&prettyprint=true&show_alternative=true");
            return this;
        }

        //"yyyy-MM-dd"
        public OpenExchangeRates Historical(String date) {
            Uri = ("https://openexchangerates.org/api/historical/" + date + ".json?app_id=" + ApiKey + "&prettyprint=true&show_alternative=true");
            return this;
        }

        public OpenExchangeRates TimeSeries(Date start, Date end) {
            Uri = ("https://openexchangerates.org/api/time-series.json?app_id=" + ApiKey + "&start=" + new SimpleDateFormat("yyyy-MM-dd").format(start) + "&end=" + new SimpleDateFormat("yyyy-MM-dd").format(end) + "&prettyprint=1");
            return this;
        }

        public OpenExchangeRates TimeSeries(String start, String end) {
            Uri = ("https://openexchangerates.org/api/time-series.json?app_id=" + ApiKey + "&start=" + start + "&end=" + end + "&prettyprint=1");

            return this;
        }

        public OpenExchangeRates Convert(int value, String from, String to) {
            Uri = ("https://openexchangerates.org/api/convert/" + String.valueOf(value) + "/" + from + "/" + to + "?app_id=" + ApiKey);
            return this;
        }

        public OpenExchangeRates Ohlc(Date date, int period) {
            Uri = ("https://openexchangerates.org/api/ohlc.json?app_id=" + ApiKey + "&start_time=" + date + "&period=" + period + "&prettyprint=true");
            return this;
        }

        //
        public OpenExchangeRates AddSymbols(String... params) {
            String currencies = "";
            for (String item : params) {
                currencies += item + ",";
            }
            currencies = currencies.substring(0, currencies.length() - 1);
            if (Uri.contains("&symbols=")) {
                Uri = Uri.replaceFirst("&symbols=(\\w*)", "&symbols=$1," + currencies);
                return this;
            }
            Uri = Uri + "&symbols=" + currencies;
            return this;
        }

        public OpenExchangeRates SetBase(String source) {
            if (Uri.contains("&base=")) {
                Uri = Uri.replaceFirst("&base=(\\w*)", "&base=" + source);
                return this;
            }
            Uri = Uri + "&base=" + source;
            return this;
        }

        public String GetString() {
            return Uri;
        }

    }
