import { expect } from "@playwright/test";

exports.EmployeeListPage = class EmployeeListPage {
    constructor(page){
        this.page = page;
        //Locators
        this.lnk_pim_css = page.locator("div[class='oxd-layout-navigation'] li[css='2']");
        this.txt_empName_xpath = page.locator("(//input[@placeholder='Type for hints...'])[1]");
        this.btn_search_css = page.locator("button[type='submit']");
        this.btn_add_xpath = page.locator("//button[normalize-space()='Add']")
        this.tr_empDetail_xpath = page.locator("//div[@class='oxd-table-body']//div[@role='row']")
        this.td_firstName_xpath = page.locator("//div[@class='oxd-table-cell oxd-padding-cell'][3]//div")
        this.td_lastName_xpath = page.locator("//div[@class='oxd-table-cell oxd-padding-cell'][4]//div")
        this.btn_editEmployeeDetails_xpath = page.locator("//i[@class='oxd-icon bi-pencil-fill']")
        this.btn_deleteEmployee_xpath = page.locator("//i[@class='oxd-icon bi-trash']")
        this.btn_confirmDelete_xpath = page.locator("//button[normalize-space()='Yes, Delete']")
        this.toast_success_xpath = page.locator("//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']")


    }
    async clickAddButton()
    {
    await this.btn_add_xpath.click();
    }
    async enterEmployeeName(name){
        await this.txt_empName_xpath.fill(name);
    }
    async clickSearchButton(){
        await this.btn_search_css.click()
    }
    async checkEmpName(firstName,lastName){
        await expect.soft(this.td_firstName_xpath).toHaveText(firstName)
        await expect.soft(this.td_lastName_xpath).toHaveText(lastName)
    }
    async clickUpdate(firstName,lastName){
        await expect.soft(this.td_firstName_xpath).toHaveText(firstName)
        await expect.soft(this.td_lastName_xpath).toHaveText(lastName)
        await this.btn_editEmployeeDetails_xpath.click()
    }
    async checkEmployeeDetailsURL(){
        await expect.soft(this.page).toHaveURL(new RegExp("/pim/viewPersonalDetails/"));
    }
    async deleteEmployee(){
        await this.btn_deleteEmployee_xpath.click();
        await this.btn_confirmDelete_xpath.click();
    }
    async checkSuccessToast(){
        await expect.soft(this.toast_success_xpath).toHaveText('Success');
    }

}