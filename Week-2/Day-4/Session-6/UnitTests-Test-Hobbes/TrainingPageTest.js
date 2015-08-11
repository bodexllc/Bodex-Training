/* W2-D4-S6 TrainingPageTest.js */

new hobs.TestSuite("Training Page Tests", {path:"/apps/geometrixx-outdoors/tests/TrainingPageTests.js", register: true})

    .addTestCase(new hobs.TestCase("First training test case")
        .navigateTo("/content/geometrixx-outdoors/en/men/shorts/jola-summer.html")
        .asserts.location("/content/geometrixx-outdoors/en/men/shorts/jola-summer.html", true)
        .asserts.visible("article.product[data-sku='mnapjs.1-S']", true)
        .asserts.visible("article.product[data-sku='mnapjs.2-S']", false)
    )
/* W2-D4-S6 TrainingPageTest.js ends*/

