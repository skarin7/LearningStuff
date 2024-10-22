import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.Content;
import org.bson.Document;

public class TestDeseriler {
    public static void main(String[] args) throws JsonProcessingException {
        String input ="{ \n" +
                "    \n" +
                "    \"contentId\" : \"ZSN9nGvQ-6wpm97uy\", \n" +
                "    \"name\" : \"Link Instance innerpage\", \n" +
                "    \"type\" : \"link\", \n" +
                "    \"value\" : [\n" +
                "        {\n" +
                "            \"name\" : \"href\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"https://{{domainName}}/us/en/discover-benefits\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"text\", \n" +
                "            \"type\" : \"richtext\", \n" +
                "            \"value\" : \"\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"title\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"ariaLabel\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"linkType\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"innerpage\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"pageId\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"page365-prod\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"innerPageLocale\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"en_us\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"innerPagePersona\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"external\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"refNum\" : \"RGORGOUS\", \n" +
                "    \"locale\" : \"en_us\", \n" +
                "    \"siteVariants\" : null, \n" +
                "    \"md5\" : \"bd344bf892f22d8aaa9c1663a335ea65VXpz0\", \n" +
                "    \"originEnv\" : \"prod\", \n" +
                "    \"tags\" : [\n" +
                "    ], \n" +
                "    \"generatedTags\" : null, \n" +
                "    \"autoTaggedRelations\" : {\n" +
                "    }, \n" +
                "    \"version\" : NumberInt(1), \n" +
                "    \"publishedVersion\" : NumberInt(0), \n" +
                "    \"translationsCount\" : NumberInt(0), \n" +
                "    \"translationType\" : null, \n" +
                "    \"localized\" : false, \n" +
                "    \"source\" : null, \n" +
                "    \"status\" : \"draft\", \n" +
                "    \"translations\" : [\n" +
                "    ], \n" +
                "    \"globalContent\" : true, \n" +
                "    \"defaultContent\" : false, \n" +
                "    \"previewContent\" : false, \n" +
                "    \"emailContent\" : false, \n" +
                "    \"createdBy\" : \"83218176-84a2-4743-bda3-b0252232d2b5\", \n" +
                "    \"latestVersion\" : true, \n" +
                "    \"createdDate\" : NumberLong(1716292909096), \n" +
                "    \"updatedBy\" : \"83218176-84a2-4743-bda3-b0252232d2b5\", \n" +
                "    \"updatedDate\" : NumberLong(1716292909096)\n" +
                "}";

        String withISO = "{ \n" +
                "    \"contentId\" : \"zvoTCJHy-g75RRvGG\", \n" +
                "    \"locale\" : \"en_us\", \n" +
                "    \"refNum\" : \"RGORGOUS\", \n" +
                "    \"type\" : \"menuitem\", \n" +
                "    \"autoTaggedRelations\" : {\n" +
                "\n" +
                "    }, \n" +
                "    \"createdBy\" : \"83218176-84a2-4743-bda3-b0252232d2b5\", \n" +
                "    \"createdDate\" : ISODate(\"2024-04-27T22:00:52.181+0000\"), \n" +
                "    \"defaultContent\" : false, \n" +
                "    \"emailContent\" : false, \n" +
                "    \"generatedTags\" : null, \n" +
                "    \"globalContent\" : true, \n" +
                "    \"latestVersion\" : true, \n" +
                "    \"localized\" : false, \n" +
                "    \"md5\" : \"545a097076b9343a46502676571d7d71LXiZoJIeCJ\", \n" +
                "    \"name\" : \"Link Instance weburl\", \n" +
                "    \"originEnv\" : \"pre-prod\", \n" +
                "    \"previewContent\" : false, \n" +
                "    \"publishedVersion\" : NumberInt(0), \n" +
                "    \"siteVariants\" : [\n" +
                "\n" +
                "    ], \n" +
                "    \"source\" : null, \n" +
                "    \"status\" : \"draft\", \n" +
                "    \"tags\" : [\n" +
                "\n" +
                "    ], \n" +
                "    \"translationType\" : null, \n" +
                "    \"translations\" : [\n" +
                "\n" +
                "    ], \n" +
                "    \"translationsCount\" : NumberInt(0), \n" +
                "    \"updatedBy\" : \"77566e7f-84ba-4f22-be0d-6cb261cdb278\", \n" +
                "    \"updatedDate\" : ISODate(\"2024-07-01T10:22:17.564+0000\"), \n" +
                "    \"value\" : [\n" +
                "        {\n" +
                "            \"name\" : \"title\", \n" +
                "            \"type\" : \"text\", \n" +
                "            \"value\" : \"Develop\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\" : \"link\", \n" +
                "            \"type\" : \"compositeType\", \n" +
                "            \"value\" : [\n" +
                "                {\n" +
                "                    \"name\" : \"text\", \n" +
                "                    \"type\" : \"text\", \n" +
                "                    \"value\" : \"Students & Grads\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"name\" : \"title\", \n" +
                "                    \"type\" : \"text\", \n" +
                "                    \"value\" : \"\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"name\" : \"link\", \n" +
                "                    \"type\" : \"reference\", \n" +
                "                    \"reference\" : \"43263DhW-6wpm97uy\", \n" +
                "                    \"refType\" : \"link\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"name\" : \"target\", \n" +
                "                    \"type\" : \"text\", \n" +
                "                    \"value\" : \"_self\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"name\" : \"ariaLabel\", \n" +
                "                    \"type\" : \"text\", \n" +
                "                    \"value\" : \"Students & Graduates\"\n" +
                "                }\n" +
                "            ], \n" +
                "            \"refType\" : \"linkwrapper\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"version\" : NumberInt(14)\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        Document parse = Document.parse(input);
        Document parse = Document.parse(withISO);
        JsonNode jsonNode = mapper.readTree(parse.toJson());
        Content content  = mapper.treeToValue(jsonNode, Content.class);
        System.out.println("updateDate : " + content.getUpdatedDate());

    }
}
