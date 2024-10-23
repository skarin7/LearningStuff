package com.practice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class CompareHtmlDOM {


/*    Element mergeHtmlElements(Element source, Element destination) {
        // traverse all children of the source element and destination element

        for (Element srcElement : source.children()) {
            // Find the corresponding element in the destination
            Elements destElement = destination.children();
            if (destElement != null) {
                System.out.println("data ph-id  of srcEleement: " + srcElement.attr("data-ph-id") +
                        " data ph-id of destElement: " + destElement.attr("data-ph-id"));
                // Merge attributes
                srcElement.attributes().forEach(attr -> destElement.attr(attr.getKey(), attr.getValue()));
                // Recursively merge child elements
                mergeHtmlElements(srcElement, destElement);
            } else {
                // Add extra elements from source to destination
                destination.appendChild(srcElement.clone());
            }
        }
        return destination;
    }*/

    private void mergeChildNodes(Element parent1, Element parent2) {
        Elements children1 = parent1.children();
        Elements children2 = parent2.children();

        int maxChildren = Math.max(children1.size(), children2.size());

        for (int i = 0; i < maxChildren; i++) {
            Node childNode1 = i < children1.size() ? children1.get(i) : null;
            Node childNode2 = i < children2.size() ? children2.get(i) : null;

            if (childNode1 != null && childNode2 != null) {
                compareAndMerge(childNode1, childNode2);
            } else if (childNode2 != null) {
                // If a child exists in the second document but not in the first, append it
                parent1.appendChild(childNode2.clone());
            }
        }
    }

    private void compareAndMerge(Node node1, Node node2) {
        if (node1 instanceof Element && node2 instanceof Element) {
            Element el1 = (Element) node1;
            Element el2 = (Element) node2;

            // Merge attributes from el2 to el1
            mergeAttributes(el1, el2);

            // Compare child nodes recursively
            mergeChildNodes(el1, el2);
        }
    }

    private static void mergeAttributes(Element target, Element source) {
        for (Attribute attr : source.attributes()) {
            if (!target.hasAttr(attr.getKey())) {
                target.attr(attr.getKey(), attr.getValue());
            }
        }
    }

    Element printAllElements(Element element) {
        Elements children = element.children();
        for (Element child : children) {
            System.out.println("Element: " + child.tagName() + " data-ph-id: " + child.attr("data-ph-id"));
            printAllElements(child);
        }
        return element;
    }
    public static void main(String[] args) {
        String dest = "<div class=\"ph-media-large-testimonial-left-cc-slider-view1-option1-theme2 ph-widget-target\" type=\"static\" as-element=\"ph-html-v1\" data-widget=\"ph-html-v1\" view=\"1718053855380-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097\" original-view=\"ph-media-large-testimonial-left-cc-slider-view1-option1\" theme=\"theme2\" ph-removed=\"true\" data-ph-id=\"-1718053854538-1\" instance-id=\"N0V4Lw\"><div class=\"ph-component-cntr ph-widget-box header-center\" default-cards-count=\"4\" role=\"region\" key-role=\"N0V4Lw-XwPwW4-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-regionRole\" aria-label=\"Carousel\" key-aria-label=\"N0V4Lw-XwPwW4-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-carouselRegion\" instance-id=\"XwPwW4\" data-ph-id=\"ph-widget-element-221233324109284-2\">\n" +
                "    <div class=\"inner-container\" data-ph-id=\"ph-widget-element-221233324109284-3\">\n" +
                "        <div class=\"ph-container-heading-block\" data-ph-id=\"ph-widget-element-221233324109284-4\">\n" +
                "            <div class=\"ph-header-block-default\" card-name=\"ph-header-block-default\" data-ph-id=\"ph-widget-element-221233324109284-5\">\n" +
                "    <div class=\"heading-block-info\" data-ph-id=\"ph-widget-element-221233324109284-6\">\n" +
                "        <ppc-container component-content-key=\"h2-heading\" class=\"heading-two\" data-ph-cid=\"h2-heading1\" data-ph-id=\"ph-widget-element-221233324109284-7\">\n" +
                "    <h2 data-ph-id=\"ph-widget-element-221233324109284-8\">\n" +
                "        <ppc-content key=\"N0V4Lw-xugD4y-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-h2-heading-title-text\" instance-id=\"xugD4y\" data-ph-id=\"ph-widget-element-221233324109284-9\">Hur ser din ICA-personlighet ut?</ppc-content>\n" +
                "    </h2>\n" +
                "</ppc-container>\n" +
                "        <ppc-container component-content-key=\"header-block-sub-content\" class=\"sub-content ph-cc-d-m-b-24\" data-ph-cid=\"header-block-sub-content1\" data-ph-id=\"ph-widget-element-221233324109284-10\">\n" +
                "    <span class=\"sub-content-block\" data-ph-id=\"ph-widget-element-221233324109284-11\">\n" +
                "        <ppc-content key=\"N0V4Lw-n1nA0n-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-header-block-sub-content-text\" instance-id=\"n1nA0n\" data-ph-id=\"ph-widget-element-221233324109284-12\">Vi tycker om att testa nya lösningar och är alltid intresserade av att lära av varandra. Hos oss får du frihet och ansvar att lösa dina uppgifter själv, men en hjälpande hand är aldrig långt borta. Känner du igen dig? Då kommer du trivas hos oss!</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "    </div>\n" +
                "    <div class=\"heading-block-actions\" data-ph-id=\"ph-widget-element-221233324109284-13\">\n" +
                "        <ppc-container component-content-key=\"header-block-primary-action-link\" class=\"header-block-primary-action-link primary-button button-sm hide\" data-ph-cid=\"header-block-primary-action-link1\" data-ph-id=\"ph-widget-element-221233324109284-14\">\n" +
                "    <a key-ph-href=\"N0V4Lw-9ePWyT-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-header-block-primary-action-link-href\" title=\"\" key-title=\"N0V4Lw-9ePWyT-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-header-block-primary-action-link-title-text\" class=\"action-link au-target\" aria-label=\"\" key-aria-label=\"N0V4Lw-9ePWyT-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-header-block-primary-link-aria-label-text\" ph-tevent=\"static_content_click\" instance-id=\"9ePWyT\" data-ph-id=\"ph-widget-element-221233324109284-15\" au-target-id=\"481\" href=\"https://apotekhjartat.dev.phenompro.com/se/sv/foretagskultur-varderingar-2024\" data-ph-href=\"foretagskultur-varderingar-2024\">\n" +
                "        <ppc-content key=\"N0V4Lw-RC5qQT-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-header-block-primary-action-link-text\" instance-id=\"RC5qQT\" data-ph-id=\"ph-widget-element-221233324109284-16\">Om vår företagskultur och värderingar</ppc-content>\n" +
                "        <i class=\"icon icon-arrow-right\" aria-hidden=\"true\" data-ph-id=\"ph-widget-element-221233324109284-17\"></i>\n" +
                "    </a>\n" +
                "</ppc-container>\n" +
                "    </div> \n" +
                "</div>\n" +
                "        </div>\n" +
                "        <div class=\"ph-container-content-block ph-static-slider\" data-ph-id=\"ph-widget-element-221233324109284-18\">\n" +
                "            <div ph-card-slider-v1=\"\" data-widget-attr=\"ph-card-slider-v1\" pha-phslide-arrows=\"true\" pha-phslide-dots=\"true\" pha-phslide-autoplay=\"true\" data-cards-per-row=\"one\" class=\"ph-card-container ph-slider-container stackable dots-circle au-target ph-slide-count-3 slick-initialized slick-slider slick-dotted\" pha-phslide-autoplay-speed=\"3000\" data-ph-id=\"ph-widget-element-221233324109284-19\" au-target-id=\"482\"><button type=\"button\" data-role=\"none\" class=\"slick-prev slick-arrow\" aria-label=\"Previous\" role=\"button\" style=\"\">Previous</button><div class=\"slick-list draggable\" role=\"presentation\"><div class=\"slick-track\" style=\"opacity: 1; width: 6220px; transform: translate3d(-2488px, 0px, 0px);\"><div class=\"ph-card au-target slick-slide slick-cloned\" card-name=\"ph-media-large-testimonial-left-cc-view1\" data-ph-card-block-alignment=\"h\" ph-role=\"\" key-ph-role=\"N0V4Lw-fKRjNy-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-listItemRole\" card-container-style=\"background-image:'url()'\" ph-slide-num=\"3\" instance-id=\"fKRjNy\" data-ph-id=\"ph-widget-element-221233324109284-150\" au-target-id=\"487\" role=\"presentation\" data-slick-index=\"-1\" id=\"\" aria-hidden=\"true\" style=\"width: 1244px;\" tabindex=\"-1\">\n" +
                "    <div class=\"ph-media-large-testimonial-left-cc-view1 ph-card-block\" data-ph-at-id=\"ph-media-large-testimonial-left-cc-view1\" data-ph-id=\"ph-widget-element-221233324109284-151\">\n" +
                "        <div class=\"ph-row v-l-middle\" ph-row-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-152\">\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-153\">\n" +
                "                <div class=\"content ph-a11y-aria-live\" aria-live=\"assertive\" aria-atomic=\"true\" ph-card-block-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-154\">\n" +
                "                    <ppc-container component-content-key=\"heading\" class=\"header element-left ph-cc-d-f-s-38\" data-ph-cid=\"heading1\" data-ph-id=\"ph-widget-element-221233324109284-155\">\n" +
                "    <span aria-level=\"\" key-aria-level=\"N0V4Lw-MBk9yp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-aria-level\" role=\"\" key-role=\"N0V4Lw-MBk9yp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-role\" instance-id=\"MBk9yp\" data-ph-id=\"ph-widget-element-221233324109284-156\">\n" +
                "        <ppc-content key=\"N0V4Lw-MCvUjz-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text\" data-ph-at-id=\"heading-text\" instance-id=\"MCvUjz\" data-ph-id=\"ph-widget-element-221233324109284-157\"><h3 data-ph-id=\"ph-widget-element-221233324109284-158\"><span class=\"ph-BK66u\" data-ph-id=\"ph-widget-element-221233324109284-159\">Passion för innovation</span></h3></ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"description\" class=\"description element-left ph-cc-d-f-s-21 ph-line-height-1_4\" data-ph-cid=\"description1\" data-ph-id=\"ph-widget-element-221233324109284-160\">\n" +
                "    <span class=\"description-block\" data-ph-id=\"ph-widget-element-221233324109284-161\">\n" +
                "        <ppc-content key=\"N0V4Lw-hl7Tby-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-description-text\" data-ph-at-id=\"description-text\" instance-id=\"hl7Tby\" data-ph-id=\"ph-widget-element-221233324109284-162\">Som den problemlösare du är vågar du tänka nytt. ICA-idén med fria handlare präglar oss och vårt innovationsarbete gör oss ledande i den digitala revolutionen av dagligvaruhandeln.</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-name\" class=\"employee-name hide\" data-ph-cid=\"employee-name1\" data-ph-id=\"ph-widget-element-221233324109284-163\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-164\">\n" +
                "        <ppc-content key=\"N0V4Lw-JfeXGo-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-title-text\" instance-id=\"JfeXGo\" data-ph-id=\"ph-widget-element-221233324109284-165\">Lorem</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-details\" class=\"employee-details hide\" data-ph-cid=\"employee-details1\" data-ph-id=\"ph-widget-element-221233324109284-166\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-167\">\n" +
                "        <ppc-content key=\"N0V4Lw-pOLFRH-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-sub-title-text\" instance-id=\"pOLFRH\" data-ph-id=\"ph-widget-element-221233324109284-168\">Ipsum</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"primary-action-link\" class=\"primary-action-link hide\" data-ph-cid=\"primary-action-link1\" data-ph-id=\"ph-widget-element-221233324109284-169\">\n" +
                "    <div class=\"link\" data-ph-at-id=\"action-default-link\" data-ph-id=\"ph-widget-element-221233324109284-170\">\n" +
                "        <a class=\"action-link au-target\" key-ph-href=\"N0V4Lw-UhvdKp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-href\" title=\"Lorem Ipsum\" key-title=\"N0V4Lw-UhvdKp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-title-text\" aria-label=\"\" key-aria-label=\"N0V4Lw-UhvdKp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-aria-label-text\" ph-tevent=\"static_content_click\" instance-id=\"UhvdKp\" data-ph-id=\"ph-widget-element-221233324109284-171\" au-target-id=\"488\" href=\"javascript:void(0)\" data-ph-href=\"javascript:void(0)\" tabindex=\"-1\">\n" +
                "            <ppc-content key=\"N0V4Lw-jPhKtv-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-text\" data-ph-at-id=\"link-text\" instance-id=\"jPhKtv\" data-ph-id=\"ph-widget-element-221233324109284-172\">Learn more</ppc-content>\n" +
                "            <i class=\"icon icon-arrow-right\" aria-hidden=\"true\" data-ph-id=\"ph-widget-element-221233324109284-173\"></i>\n" +
                "        </a>\n" +
                "    </div>\n" +
                "</ppc-container>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-174\">\n" +
                "                <div class=\"media\" ph-card-block-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-175\">\n" +
                "                    <figure class=\"image\" data-ph-id=\"ph-widget-element-221233324109284-176\">\n" +
                "                        <ppc-container component-content-key=\"primary-image\" class=\"primary-image\" unique-img=\"true\" data-ph-cid=\"primary-image1\" data-ph-id=\"ph-widget-element-221233324109284-177\">\n" +
                "    <ppc-content type=\"image\" data-ph-media=\"image\" data-ph-id=\"ph-widget-element-221233324109284-178\">\n" +
                "        <img src=\"https://cdn.phenompeople.com/CareerConnectResources/pp/ICAAHVSE/images/ICA_102-24-9-1709834074811.jpg\" key-src=\"N0V4Lw-JQmD8D-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-src\" alt=\"img1\" key-alt=\"N0V4Lw-JQmD8D-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-alt-text\" unique-img=\"true\" data-ph-cid=\"primary-image1\" height-val=\"311\" instance-id=\"JQmD8D\" data-ph-id=\"ph-widget-element-221233324109284-179\" loading=\"lazy\" aria-hidden=\"true\">\n" +
                "    </ppc-content>\n" +
                "</ppc-container>\n" +
                "                    </figure>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div><div class=\"ph-card au-target slick-slide\" card-name=\"ph-media-large-testimonial-left-cc-view1\" data-ph-card-block-alignment=\"h\" ph-role=\"\" key-ph-role=\"N0V4Lw-IkB7EU-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-listItemRole\" card-container-style=\"background-image:'url()'\" instance-id=\"IkB7EU\" data-ph-id=\"ph-widget-element-221233324109284-20\" ph-slide-num=\"1\" au-target-id=\"483\" data-slick-index=\"0\" aria-hidden=\"true\" style=\"width: 1244px;\" id=\"slick-slide00\" tabindex=\"-1\">\n" +
                "    <div class=\"ph-media-large-testimonial-left-cc-view1 ph-card-block\" data-ph-at-id=\"ph-media-large-testimonial-left-cc-view1\" data-ph-id=\"ph-widget-element-221233324109284-21\">\n" +
                "        <div class=\"ph-row v-l-middle\" ph-row-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-22\">\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-23\">\n" +
                "                <div class=\"content ph-a11y-aria-live\" ph-card-block-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-24\">\n" +
                "                    <ppc-container component-content-key=\"heading\" class=\"header element-left ph-cc-d-f-s-38\" data-ph-cid=\"heading1\" data-ph-id=\"ph-widget-element-221233324109284-25\">\n" +
                "    <span aria-level=\"\" key-aria-level=\"N0V4Lw-cejY8i-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-aria-level\" role=\"\" key-role=\"N0V4Lw-cejY8i-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-role\" instance-id=\"cejY8i\" data-ph-id=\"ph-widget-element-221233324109284-26\">\n" +
                "        <ppc-content key=\"N0V4Lw-a0q4qY-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text\" data-ph-at-id=\"heading-text\" instance-id=\"a0q4qY\" data-ph-id=\"ph-widget-element-221233324109284-27\"><h3 data-ph-id=\"ph-widget-element-221233324109284-28\"><span class=\"ph-BK66u\" data-ph-id=\"ph-widget-element-221233324109284-29\">Var den du är</span></h3></ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"description\" class=\"description element-left ph-cc-d-f-s-21 ph-line-height-1_4\" data-ph-cid=\"description1\" data-ph-id=\"ph-widget-element-221233324109284-30\">\n" +
                "    <span class=\"description-block\" data-ph-id=\"ph-widget-element-221233324109284-31\">\n" +
                "        <ppc-content key=\"N0V4Lw-v0OyDt-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-description-text\" data-ph-at-id=\"description-text\" instance-id=\"v0OyDt\" data-ph-id=\"ph-widget-element-221233324109284-32\">Vår kultur är öppen och inbjudande och här får du vara dig själv. ICA präglas av ett motiverande och stöttande klimat med en nolltolerans mot diskriminering.</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-name\" class=\"employee-name hide\" data-ph-cid=\"employee-name1\" data-ph-id=\"ph-widget-element-221233324109284-33\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-34\">\n" +
                "        <ppc-content key=\"N0V4Lw-VGqpgf-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-title-text\" instance-id=\"VGqpgf\" data-ph-id=\"ph-widget-element-221233324109284-35\">Lorem</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-details\" class=\"employee-details hide\" data-ph-cid=\"employee-details1\" data-ph-id=\"ph-widget-element-221233324109284-36\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-37\">\n" +
                "        <ppc-content key=\"N0V4Lw-FXbcEs-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-sub-title-text\" instance-id=\"FXbcEs\" data-ph-id=\"ph-widget-element-221233324109284-38\">Ipsum</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"primary-action-link\" class=\"primary-action-link hide\" data-ph-cid=\"primary-action-link1\" data-ph-id=\"ph-widget-element-221233324109284-39\">\n" +
                "    <div class=\"link\" data-ph-at-id=\"action-default-link\" data-ph-id=\"ph-widget-element-221233324109284-40\">\n" +
                "        <a class=\"action-link au-target\" key-ph-href=\"N0V4Lw-dt51vD-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-href\" title=\"Lorem Ipsum\" key-title=\"N0V4Lw-dt51vD-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-title-text\" aria-label=\"\" key-aria-label=\"N0V4Lw-dt51vD-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-aria-label-text\" ph-tevent=\"static_content_click\" instance-id=\"dt51vD\" data-ph-id=\"ph-widget-element-221233324109284-41\" au-target-id=\"484\" href=\"javascript:void(0)\" data-ph-href=\"javascript:void(0)\" tabindex=\"-1\">\n" +
                "            <ppc-content key=\"N0V4Lw-2GaO1a-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-text\" data-ph-at-id=\"link-text\" instance-id=\"2GaO1a\" data-ph-id=\"ph-widget-element-221233324109284-42\">Learn more</ppc-content>\n" +
                "            <i class=\"icon icon-arrow-right\" aria-hidden=\"true\" data-ph-id=\"ph-widget-element-221233324109284-43\"></i>\n" +
                "        </a>\n" +
                "    </div>\n" +
                "</ppc-container>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-44\">\n" +
                "                <div class=\"media\" ph-card-block-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-45\">\n" +
                "                    <figure class=\"image\" data-ph-id=\"ph-widget-element-221233324109284-46\">\n" +
                "                        <ppc-container component-content-key=\"primary-image\" class=\"primary-image\" unique-img=\"true\" data-ph-cid=\"primary-image1\" data-ph-id=\"ph-widget-element-221233324109284-47\">\n" +
                "    <ppc-content type=\"image\" data-ph-media=\"image\" data-ph-id=\"ph-widget-element-221233324109284-48\">\n" +
                "        <img src=\"https://cdn.phenompeople.com/CareerConnectResources/pp/ICAAHVSE/images/ICA_31-21-9-1708550551125.jpg\" key-src=\"N0V4Lw-Mc4AbA-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-src\" alt=\"img1\" key-alt=\"N0V4Lw-Mc4AbA-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-alt-text\" unique-img=\"true\" data-ph-cid=\"primary-image1\" height-val=\"311\" instance-id=\"Mc4AbA\" data-ph-id=\"ph-widget-element-221233324109284-49\" loading=\"lazy\" aria-hidden=\"true\">\n" +
                "    </ppc-content>\n" +
                "</ppc-container>\n" +
                "                    </figure>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div><div class=\"ph-card au-target slick-slide slick-current slick-active\" card-name=\"ph-media-large-testimonial-left-cc-view1\" data-ph-card-block-alignment=\"h\" ph-role=\"\" key-ph-role=\"N0V4Lw-EC8jFM-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-listItemRole\" card-container-style=\"background-image:'url()'\" instance-id=\"EC8jFM\" data-ph-id=\"ph-widget-element-221233324109284-83\" ph-slide-num=\"2\" au-target-id=\"485\" data-slick-index=\"1\" aria-hidden=\"false\" style=\"width: 1244px;\" id=\"slick-slide01\">\n" +
                "    <div class=\"ph-media-large-testimonial-left-cc-view1 ph-card-block\" data-ph-at-id=\"ph-media-large-testimonial-left-cc-view1\" data-ph-id=\"ph-widget-element-221233324109284-84\">\n" +
                "        <div class=\"ph-row v-l-middle\" ph-row-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-85\">\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-86\">\n" +
                "                <div class=\"content ph-a11y-aria-live\" ph-card-block-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-87\">\n" +
                "                    <ppc-container component-content-key=\"heading\" class=\"header\" data-ph-cid=\"heading1\" data-ph-id=\"ph-widget-element-221233324109284-88\">\n" +
                "    <span aria-level=\"\" key-aria-level=\"N0V4Lw-Xi4ZoV-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-aria-level\" role=\"\" key-role=\"N0V4Lw-Xi4ZoV-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-role\" instance-id=\"Xi4ZoV\" data-ph-id=\"ph-widget-element-221233324109284-89\">\n" +
                "        <ppc-content key=\"N0V4Lw-FigNwF-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text\" data-ph-at-id=\"heading-text\" instance-id=\"FigNwF\" data-ph-id=\"ph-widget-element-221233324109284-90\"><h3 style=\"text-align: left;\" data-ph-id=\"ph-widget-element-221233324109284-91\"><span class=\"ph-BK66u\" data-ph-id=\"ph-widget-element-221233324109284-92\">Här är alla ledare</span></h3></ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"description\" class=\"description\" data-ph-cid=\"description1\" data-ph-id=\"ph-widget-element-221233324109284-93\">\n" +
                "    <span class=\"description-block\" data-ph-id=\"ph-widget-element-221233324109284-94\">\n" +
                "        <ppc-content key=\"N0V4Lw-9DZ9Im-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-description-text\" data-ph-at-id=\"description-text\" instance-id=\"9DZ9Im\" data-ph-id=\"ph-widget-element-221233324109284-95\"><div style=\"text-align: left;\" data-ph-id=\"ph-widget-element-221233324109284-96\"><span class=\"ph-cc-ms-f-s-21 ph-cc-d-f-s-21 ph-cc-t-f-s-16 ph-cc-m-f-s-16\" data-ph-id=\"ph-widget-element-221233324109284-97\"><span class=\"ph-line-height-1_5\" data-ph-process-line-height=\"true\" data-ph-style-attr=\"ph-line-height-1_5\" data-ph-id=\"ph-widget-element-221233324109284-98\"><span style=\"line-height: inherit !important; display: inherit;\" data-ph-id=\"ph-widget-element-221233324109284-99\">Gott ledarskap är nyckeln till din resa framåt – både det hos dina chefer och ditt eget självledarskap. Du får verktyg för att kunna arbeta med frihet under ansvar.</span></span></span></div></ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-name\" class=\"employee-name hide\" data-ph-cid=\"employee-name1\" data-ph-id=\"ph-widget-element-221233324109284-100\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-101\">\n" +
                "        <ppc-content key=\"N0V4Lw-UH1ybD-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-title-text\" instance-id=\"UH1ybD\" data-ph-id=\"ph-widget-element-221233324109284-102\">Lorem</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-details\" class=\"employee-details hide\" data-ph-cid=\"employee-details1\" data-ph-id=\"ph-widget-element-221233324109284-103\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-104\">\n" +
                "        <ppc-content key=\"N0V4Lw-MNAZkv-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-sub-title-text\" instance-id=\"MNAZkv\" data-ph-id=\"ph-widget-element-221233324109284-105\">Ipsum</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"primary-action-link\" class=\"primary-action-link hide\" data-ph-cid=\"primary-action-link1\" data-ph-id=\"ph-widget-element-221233324109284-106\">\n" +
                "    <div class=\"link\" data-ph-at-id=\"action-default-link\" data-ph-id=\"ph-widget-element-221233324109284-107\">\n" +
                "        <a class=\"action-link au-target\" key-ph-href=\"N0V4Lw-qvX8Hb-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-href\" title=\"Lorem Ipsum\" key-title=\"N0V4Lw-qvX8Hb-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-title-text\" aria-label=\"\" key-aria-label=\"N0V4Lw-qvX8Hb-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-aria-label-text\" ph-tevent=\"static_content_click\" instance-id=\"qvX8Hb\" data-ph-id=\"ph-widget-element-221233324109284-108\" au-target-id=\"486\" href=\"javascript:void(0)\" data-ph-href=\"javascript:void(0)\" tabindex=\"0\">\n" +
                "            <ppc-content key=\"N0V4Lw-ixF9H6-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-text\" data-ph-at-id=\"link-text\" instance-id=\"ixF9H6\" data-ph-id=\"ph-widget-element-221233324109284-109\">Learn more</ppc-content>\n" +
                "            <i class=\"icon icon-arrow-right\" aria-hidden=\"true\" data-ph-id=\"ph-widget-element-221233324109284-110\"></i>\n" +
                "        </a>\n" +
                "    </div>\n" +
                "</ppc-container>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-111\">\n" +
                "                <div class=\"media\" ph-card-block-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-112\">\n" +
                "                    <figure class=\"image\" data-ph-id=\"ph-widget-element-221233324109284-113\">\n" +
                "                        <ppc-container component-content-key=\"primary-image\" class=\"primary-image\" unique-img=\"true\" data-ph-cid=\"primary-image1\" data-ph-id=\"ph-widget-element-221233324109284-114\">\n" +
                "    <ppc-content type=\"image\" data-ph-media=\"image\" data-ph-id=\"ph-widget-element-221233324109284-115\">\n" +
                "        <img src=\"https://cdn.phenompeople.com/CareerConnectResources/pp/ICAAHVSE/images/ICA_56-24-9-1709833674243.jpg\" key-src=\"N0V4Lw-XdHCXl-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-src\" alt=\"img1\" key-alt=\"N0V4Lw-XdHCXl-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-alt-text\" unique-img=\"true\" data-ph-cid=\"primary-image1\" height-val=\"151\" instance-id=\"XdHCXl\" data-ph-id=\"ph-widget-element-221233324109284-116\" loading=\"lazy\" aria-hidden=\"false\">\n" +
                "    </ppc-content>\n" +
                "</ppc-container>\n" +
                "                    </figure>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div><div class=\"ph-card au-target slick-slide\" card-name=\"ph-media-large-testimonial-left-cc-view1\" data-ph-card-block-alignment=\"h\" ph-role=\"\" key-ph-role=\"N0V4Lw-fKRjNy-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-listItemRole\" card-container-style=\"background-image:'url()'\" ph-slide-num=\"3\" instance-id=\"fKRjNy\" data-ph-id=\"ph-widget-element-221233324109284-150\" au-target-id=\"487\" data-slick-index=\"2\" aria-hidden=\"true\" style=\"width: 1244px;\" id=\"slick-slide02\" tabindex=\"-1\">\n" +
                "    <div class=\"ph-media-large-testimonial-left-cc-view1 ph-card-block\" data-ph-at-id=\"ph-media-large-testimonial-left-cc-view1\" data-ph-id=\"ph-widget-element-221233324109284-151\">\n" +
                "        <div class=\"ph-row v-l-middle\" ph-row-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-152\">\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-153\">\n" +
                "                <div class=\"content ph-a11y-aria-live\" ph-card-block-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-154\">\n" +
                "                    <ppc-container component-content-key=\"heading\" class=\"header element-left ph-cc-d-f-s-38\" data-ph-cid=\"heading1\" data-ph-id=\"ph-widget-element-221233324109284-155\">\n" +
                "    <span aria-level=\"\" key-aria-level=\"N0V4Lw-MBk9yp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-aria-level\" role=\"\" key-role=\"N0V4Lw-MBk9yp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-role\" instance-id=\"MBk9yp\" data-ph-id=\"ph-widget-element-221233324109284-156\">\n" +
                "        <ppc-content key=\"N0V4Lw-MCvUjz-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text\" data-ph-at-id=\"heading-text\" instance-id=\"MCvUjz\" data-ph-id=\"ph-widget-element-221233324109284-157\"><h3 data-ph-id=\"ph-widget-element-221233324109284-158\"><span class=\"ph-BK66u\" data-ph-id=\"ph-widget-element-221233324109284-159\">Passion för innovation</span></h3></ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"description\" class=\"description element-left ph-cc-d-f-s-21 ph-line-height-1_4\" data-ph-cid=\"description1\" data-ph-id=\"ph-widget-element-221233324109284-160\">\n" +
                "    <span class=\"description-block\" data-ph-id=\"ph-widget-element-221233324109284-161\">\n" +
                "        <ppc-content key=\"N0V4Lw-hl7Tby-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-description-text\" data-ph-at-id=\"description-text\" instance-id=\"hl7Tby\" data-ph-id=\"ph-widget-element-221233324109284-162\">Som den problemlösare du är vågar du tänka nytt. ICA-idén med fria handlare präglar oss och vårt innovationsarbete gör oss ledande i den digitala revolutionen av dagligvaruhandeln.</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-name\" class=\"employee-name hide\" data-ph-cid=\"employee-name1\" data-ph-id=\"ph-widget-element-221233324109284-163\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-164\">\n" +
                "        <ppc-content key=\"N0V4Lw-JfeXGo-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-title-text\" instance-id=\"JfeXGo\" data-ph-id=\"ph-widget-element-221233324109284-165\">Lorem</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-details\" class=\"employee-details hide\" data-ph-cid=\"employee-details1\" data-ph-id=\"ph-widget-element-221233324109284-166\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-167\">\n" +
                "        <ppc-content key=\"N0V4Lw-pOLFRH-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-sub-title-text\" instance-id=\"pOLFRH\" data-ph-id=\"ph-widget-element-221233324109284-168\">Ipsum</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"primary-action-link\" class=\"primary-action-link hide\" data-ph-cid=\"primary-action-link1\" data-ph-id=\"ph-widget-element-221233324109284-169\">\n" +
                "    <div class=\"link\" data-ph-at-id=\"action-default-link\" data-ph-id=\"ph-widget-element-221233324109284-170\">\n" +
                "        <a class=\"action-link au-target\" key-ph-href=\"N0V4Lw-UhvdKp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-href\" title=\"Lorem Ipsum\" key-title=\"N0V4Lw-UhvdKp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-title-text\" aria-label=\"\" key-aria-label=\"N0V4Lw-UhvdKp-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-aria-label-text\" ph-tevent=\"static_content_click\" instance-id=\"UhvdKp\" data-ph-id=\"ph-widget-element-221233324109284-171\" au-target-id=\"488\" href=\"javascript:void(0)\" data-ph-href=\"javascript:void(0)\" tabindex=\"-1\">\n" +
                "            <ppc-content key=\"N0V4Lw-jPhKtv-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-text\" data-ph-at-id=\"link-text\" instance-id=\"jPhKtv\" data-ph-id=\"ph-widget-element-221233324109284-172\">Learn more</ppc-content>\n" +
                "            <i class=\"icon icon-arrow-right\" aria-hidden=\"true\" data-ph-id=\"ph-widget-element-221233324109284-173\"></i>\n" +
                "        </a>\n" +
                "    </div>\n" +
                "</ppc-container>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-174\">\n" +
                "                <div class=\"media\" ph-card-block-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-175\">\n" +
                "                    <figure class=\"image\" data-ph-id=\"ph-widget-element-221233324109284-176\">\n" +
                "                        <ppc-container component-content-key=\"primary-image\" class=\"primary-image\" unique-img=\"true\" data-ph-cid=\"primary-image1\" data-ph-id=\"ph-widget-element-221233324109284-177\">\n" +
                "    <ppc-content type=\"image\" data-ph-media=\"image\" data-ph-id=\"ph-widget-element-221233324109284-178\">\n" +
                "        <img src=\"https://cdn.phenompeople.com/CareerConnectResources/pp/ICAAHVSE/images/ICA_102-24-9-1709834074811.jpg\" key-src=\"N0V4Lw-JQmD8D-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-src\" alt=\"img1\" key-alt=\"N0V4Lw-JQmD8D-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-alt-text\" unique-img=\"true\" data-ph-cid=\"primary-image1\" height-val=\"311\" instance-id=\"JQmD8D\" data-ph-id=\"ph-widget-element-221233324109284-179\" loading=\"lazy\" aria-hidden=\"true\">\n" +
                "    </ppc-content>\n" +
                "</ppc-container>\n" +
                "                    </figure>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div><div class=\"ph-card au-target slick-slide slick-cloned\" card-name=\"ph-media-large-testimonial-left-cc-view1\" data-ph-card-block-alignment=\"h\" ph-role=\"\" key-ph-role=\"N0V4Lw-IkB7EU-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-listItemRole\" card-container-style=\"background-image:'url()'\" instance-id=\"IkB7EU\" data-ph-id=\"ph-widget-element-221233324109284-20\" ph-slide-num=\"1\" au-target-id=\"483\" role=\"presentation\" data-slick-index=\"3\" id=\"\" aria-hidden=\"true\" style=\"width: 1244px;\" tabindex=\"-1\">\n" +
                "    <div class=\"ph-media-large-testimonial-left-cc-view1 ph-card-block\" data-ph-at-id=\"ph-media-large-testimonial-left-cc-view1\" data-ph-id=\"ph-widget-element-221233324109284-21\">\n" +
                "        <div class=\"ph-row v-l-middle\" ph-row-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-22\">\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-23\">\n" +
                "                <div class=\"content ph-a11y-aria-live\" aria-live=\"assertive\" aria-atomic=\"true\" ph-card-block-num=\"1\" data-ph-id=\"ph-widget-element-221233324109284-24\">\n" +
                "                    <ppc-container component-content-key=\"heading\" class=\"header element-left ph-cc-d-f-s-38\" data-ph-cid=\"heading1\" data-ph-id=\"ph-widget-element-221233324109284-25\">\n" +
                "    <span aria-level=\"\" key-aria-level=\"N0V4Lw-cejY8i-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-aria-level\" role=\"\" key-role=\"N0V4Lw-cejY8i-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text-role\" instance-id=\"cejY8i\" data-ph-id=\"ph-widget-element-221233324109284-26\">\n" +
                "        <ppc-content key=\"N0V4Lw-a0q4qY-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-heading-text\" data-ph-at-id=\"heading-text\" instance-id=\"a0q4qY\" data-ph-id=\"ph-widget-element-221233324109284-27\"><h3 data-ph-id=\"ph-widget-element-221233324109284-28\"><span class=\"ph-BK66u\" data-ph-id=\"ph-widget-element-221233324109284-29\">Var den du är</span></h3></ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"description\" class=\"description element-left ph-cc-d-f-s-21 ph-line-height-1_4\" data-ph-cid=\"description1\" data-ph-id=\"ph-widget-element-221233324109284-30\">\n" +
                "    <span class=\"description-block\" data-ph-id=\"ph-widget-element-221233324109284-31\">\n" +
                "        <ppc-content key=\"N0V4Lw-v0OyDt-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-description-text\" data-ph-at-id=\"description-text\" instance-id=\"v0OyDt\" data-ph-id=\"ph-widget-element-221233324109284-32\">Vår kultur är öppen och inbjudande och här får du vara dig själv. ICA präglas av ett motiverande och stöttande klimat med en nolltolerans mot diskriminering.</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-name\" class=\"employee-name hide\" data-ph-cid=\"employee-name1\" data-ph-id=\"ph-widget-element-221233324109284-33\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-34\">\n" +
                "        <ppc-content key=\"N0V4Lw-VGqpgf-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-title-text\" instance-id=\"VGqpgf\" data-ph-id=\"ph-widget-element-221233324109284-35\">Lorem</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"employee-details\" class=\"employee-details hide\" data-ph-cid=\"employee-details1\" data-ph-id=\"ph-widget-element-221233324109284-36\">\n" +
                "    <span data-ph-id=\"ph-widget-element-221233324109284-37\">\n" +
                "        <ppc-content key=\"N0V4Lw-FXbcEs-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-employee-details-emp-sub-title-text\" instance-id=\"FXbcEs\" data-ph-id=\"ph-widget-element-221233324109284-38\">Ipsum</ppc-content>\n" +
                "    </span>\n" +
                "</ppc-container>\n" +
                "                    <ppc-container component-content-key=\"primary-action-link\" class=\"primary-action-link hide\" data-ph-cid=\"primary-action-link1\" data-ph-id=\"ph-widget-element-221233324109284-39\">\n" +
                "    <div class=\"link\" data-ph-at-id=\"action-default-link\" data-ph-id=\"ph-widget-element-221233324109284-40\">\n" +
                "        <a class=\"action-link au-target\" key-ph-href=\"N0V4Lw-dt51vD-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-href\" title=\"Lorem Ipsum\" key-title=\"N0V4Lw-dt51vD-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-title-text\" aria-label=\"\" key-aria-label=\"N0V4Lw-dt51vD-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-aria-label-text\" ph-tevent=\"static_content_click\" instance-id=\"dt51vD\" data-ph-id=\"ph-widget-element-221233324109284-41\" au-target-id=\"484\" href=\"javascript:void(0)\" data-ph-href=\"javascript:void(0)\" tabindex=\"-1\">\n" +
                "            <ppc-content key=\"N0V4Lw-2GaO1a-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-primary-link-text\" data-ph-at-id=\"link-text\" instance-id=\"2GaO1a\" data-ph-id=\"ph-widget-element-221233324109284-42\">Learn more</ppc-content>\n" +
                "            <i class=\"icon icon-arrow-right\" aria-hidden=\"true\" data-ph-id=\"ph-widget-element-221233324109284-43\"></i>\n" +
                "        </a>\n" +
                "    </div>\n" +
                "</ppc-container>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"ph-col-6\" ph-col-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-44\">\n" +
                "                <div class=\"media\" ph-card-block-num=\"2\" data-ph-id=\"ph-widget-element-221233324109284-45\">\n" +
                "                    <figure class=\"image\" data-ph-id=\"ph-widget-element-221233324109284-46\">\n" +
                "                        <ppc-container component-content-key=\"primary-image\" class=\"primary-image\" unique-img=\"true\" data-ph-cid=\"primary-image1\" data-ph-id=\"ph-widget-element-221233324109284-47\">\n" +
                "    <ppc-content type=\"image\" data-ph-media=\"image\" data-ph-id=\"ph-widget-element-221233324109284-48\">\n" +
                "        <img src=\"https://cdn.phenompeople.com/CareerConnectResources/pp/ICAAHVSE/images/ICA_31-21-9-1708550551125.jpg\" key-src=\"N0V4Lw-Mc4AbA-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-src\" alt=\"img1\" key-alt=\"N0V4Lw-Mc4AbA-ph-media-large-testimonial-left-cc-slider-view1-option1-savedView-1718053809097-savedView-1709835009464-image-alt-text\" unique-img=\"true\" data-ph-cid=\"primary-image1\" height-val=\"311\" instance-id=\"Mc4AbA\" data-ph-id=\"ph-widget-element-221233324109284-49\" loading=\"lazy\" aria-hidden=\"true\">\n" +
                "    </ppc-content>\n" +
                "</ppc-container>\n" +
                "                    </figure>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div></div></div><button type=\"button\" data-role=\"none\" class=\"slick-next slick-arrow\" aria-label=\"Next\" role=\"button\" style=\"\">Next</button><div class=\"slick-dots\" style=\"\"><button type=\"button\" data-role=\"none\" role=\"button\" tabindex=\"0\" class=\"\" aria-current=\"false\" aria-label=\" slide 1 of 3\">1</button><button type=\"button\" data-role=\"none\" role=\"button\" tabindex=\"0\" aria-current=\"true\" aria-label=\" slide 2 of 3\" class=\"slick-active\">2</button><button type=\"button\" data-role=\"none\" role=\"button\" tabindex=\"0\" aria-current=\"false\" aria-label=\" slide 3 of 3\" class=\"\">3</button></div></div>\n" +
                "        <div class=\"ph-a11y-readable-content sr-only\"><div role=\"presentation\" aria-live=\"assertive\" aria-atomic=\"true\" aria-hidden=\"true\"></div></div></div>\n" +
                "    </div>\n" +
                "</div></div>";

        //jsoup parse the html
        Element destElement = Jsoup.parseBodyFragment(dest, "").body().getElementsByAttribute("as-element").first();
//        Element destElement = Jsoup.parse(dest).getElementById("as-element");
        CompareHtmlDOM compareHtmlDOM = new CompareHtmlDOM();
        Element srcElementElement = compareHtmlDOM.removeAllAttrs(destElement);
//        Map<String, String> dupKeys = new HashMap<>();
        compareHtmlDOM.compareAndMerge(srcElementElement, destElement);


    }

    private Element removeAllAttrs(Element srcElement) {
        Element dest = srcElement.clone();
        //remove all html attributes from all elements in the html
        Elements elements = dest.getAllElements();
        for (Element element : elements) {
            //remove prefixes from attribute value of attr 'key'
            if (element.hasAttr("key")) {
                String key = element.attr("key");
                // key value should contain last suffix before -
                if (key.contains("N0V4Lw-")) {
                    key = key.replace("N0V4Lw-", "");
                    element.attr("key", key);
                }
            }

        }
        return dest;
    }
}

