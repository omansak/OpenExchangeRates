String Uri = new OpenExchangeRates(ApiKey).Latest().SetBase("USD").AddSymbols("TRY", "EUR", "AED").GetString();
