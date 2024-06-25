import {test,expect} from '@playwright/test';
import {LoginPage} from '../pageObjects/LoginPage';
import {DashboardPage} from '../pageObjects/DashboardPage';
import {EmployeeListPage} from '../pageObjects/EmployeeListPage';
import {AddEmployeePage} from '../pageObjects/AddEmployeePage';


let firstName = "Jason"
let lastName = "Matthew"

test('test_add_employee_page @sanity @regression@now',async({page}) => {
    const login = new LoginPage(page);
    await login.login();
    const dashboard = new DashboardPage(page);
    await dashboard.goToEmployeeListPage();
    const empList = new EmployeeListPage(page);
    await empList.clickAddButton();
    const addEmp = new AddEmployeePage(page);
    await addEmp.enterDetails(firstName, lastName);
    await addEmp.clickSave()
    await addEmp.checkSuccessToast()

});

