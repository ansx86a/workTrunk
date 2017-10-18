package 驗証.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.Dereferencing;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class Fge {

	public static void main(String[] args) throws Exception {

		Fge f = new Fge();
		// f.$1測required();
		// f.$2ref的inline寫法展示();
		// f.$3同$1只是把required放到field而已();

		// $3不明原因出現warning: the following keywords are unknown and will be ignored:
		// [definitions]，待有空再查吧

		// f.$4使用Uri取得schema();

		f.$5同一個namespace可直接ref檔案();// namespace為同一個目錄吧？不同目錄應該不行吧
	}

	public void $1測required() throws Exception {
		final JsonNode fstabSchema = Utils.loadResource("/fstab.json");

		// 先測一下pattern，主是測patternProperties
		// patternProperties可以不用hardcord schema的field
		String pattern = "^/([^/]+(/[^/]+)*)?$";// [^/]這可能當成表示任何文字的意思吧
		System.out.println("/".matches(pattern));
		System.out.println("/tmp".matches(pattern));
		System.out.println("/var/lib/mysql".matches(pattern));
		System.out.println("/中文".matches("^(/[^/]+)+$"));
		System.out.println("/中文/中文2/中文3".matches("^(/[^/]+)+$"));// 第一個/後面[^/]接任意字多個
		System.out.println("/中文/中文2/中文3/".matches("^(/[^/]+)+$"));// 故意錯誤的例子

		final JsonNode good = Utils.loadResource("/fstab-good.json");
		final JsonNode bad = Utils.loadResource("/fstab-bad.json");
		final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");

		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

		final JsonSchema schema = factory.getJsonSchema(fstabSchema);

		ProcessingReport report;

		report = schema.validate(good);
		System.out.println(report);

		report = schema.validate(bad);
		System.out.println("下面的出包原因是少了必要的swap");
		System.out.println(report);

		report = schema.validate(bad2);
		System.out.println("下面的出包原因是少了必要的fstype在/definitions/mntent的參考中");

		System.out.println(report);
	}

	public void $2ref的inline寫法展示() throws Exception {
		final JsonNode fstabSchema = Utils.loadResource("/fstab-inline.json");
		final JsonNode good = Utils.loadResource("/fstab-good.json");
		final JsonNode bad = Utils.loadResource("/fstab-bad.json");
		final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");

		// 這裡的重點應該是inline的設定，雖然下面的都跑出錯誤
		// "definitions": {"mntent": {
		// 由"$ref": "#/definitions/mntent" 變成"$ref": "#mntent"
		final LoadingConfiguration cfg = LoadingConfiguration.newBuilder().dereferencing(Dereferencing.INLINE).freeze();
		final JsonSchemaFactory factory = JsonSchemaFactory.newBuilder().setLoadingConfiguration(cfg).freeze();

		final JsonSchema schema = factory.getJsonSchema(fstabSchema);

		ProcessingReport report;

		report = schema.validate(good);
		System.out.println(report);

		report = schema.validate(bad);
		System.out.println(report);

		report = schema.validate(bad2);
		System.out.println(report);
	}

	public void $3同$1只是把required放到field而已() throws Exception {
		final JsonNode fstabSchema = Utils.loadResource("/fstab-draftv3.json");
		final JsonNode good = Utils.loadResource("/fstab-good.json");
		final JsonNode bad = Utils.loadResource("/fstab-bad.json");
		final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");

		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

		final JsonSchema schema = factory.getJsonSchema(fstabSchema);

		ProcessingReport report;

		report = schema.validate(good);
		System.out.println(report);

		report = schema.validate(bad);
		System.out.println(report);

		report = schema.validate(bad2);
		System.out.println(report);

	}

	public void $4使用Uri取得schema() throws Exception {
		final JsonNode good = Utils.loadResource("/fstab-good.json");
		final JsonNode bad = Utils.loadResource("/fstab-bad.json");
		final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");

		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		// final String SCHEMA_URI = "resource:/驗証/json/fstab.json";
		final String SCHEMA_URI = "resource:/驗証/json/fstab-sub.json#/fstab";// 也可以用sub的方式取得
		final JsonSchema schema = factory.getJsonSchema(SCHEMA_URI);

		ProcessingReport report;

		report = schema.validate(good);
		System.out.println(report);

		report = schema.validate(bad);
		System.out.println(report);

		report = schema.validate(bad2);
		System.out.println(report);

	}

	public void $5同一個namespace可直接ref檔案() throws Exception {
		final JsonNode good = Utils.loadResource("/fstab-good.json");
		final JsonNode bad = Utils.loadResource("/fstab-bad.json");
		final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");
		final String NAMESPACE = "resource:/驗証/json/split/";

		final URITranslatorConfiguration translatorCfg = URITranslatorConfiguration.newBuilder()
				.setNamespace(NAMESPACE).freeze();
		final LoadingConfiguration cfg = LoadingConfiguration.newBuilder().setURITranslatorConfiguration(translatorCfg)
				.freeze();

		final JsonSchemaFactory factory = JsonSchemaFactory.newBuilder().setLoadingConfiguration(cfg).freeze();

		final JsonSchema schema = factory.getJsonSchema("fstab.json");

		ProcessingReport report;

		report = schema.validate(good);
		System.out.println(report);

		report = schema.validate(bad);
		System.out.println(report);

		report = schema.validate(bad2);
		System.out.println(report);
	}

}
