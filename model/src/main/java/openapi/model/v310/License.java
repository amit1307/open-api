package openapi.model.v310;

import javax.validation.constraints.NotNull;
import java.net.URL;

//  TODO: should we add SPDX ( https://spdx.dev/spdx-specification-21-web-version/#h.jxpfx0ykyb60 ) validation for the identifier

/**
 * License information for the exposed API.
 *
 * @param name The license name used for the API.
 * @param identifier An SPDX license expression for the API. The identifier field is mutually exclusive of the url field.
 * @param url A URL to the license used for the API. This MUST be in the form of a URL. The url field is mutually exclusive of the identifier field.
 */
public record License(@NotNull String name, String identifier, URL url) {
    public License {
        if (identifier != null && url != null) throw new IllegalArgumentException("A license can't have both an identifier and a url");
    }

    public License(@NotNull String name, String identifier) {
        this(name, identifier, null);
    }

    public License(@NotNull String name, URL url) {
        this(name, null, url);
    }
}
