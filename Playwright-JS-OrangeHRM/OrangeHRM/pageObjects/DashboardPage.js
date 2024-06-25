import { expect } from "@playwright/test";

exports.DashboardPage = class DashboardPage {
    constructor(page){
        this.page = page;
        //Locators
        this.lnk_pim_xpath = page.locator("//span[normalize-space()='PIM']");
    }

    async goToEmployeeListPage(){
        await this.lnk_pim_xpath.click();
        await expect.soft(this.page).toHaveURL("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }
}