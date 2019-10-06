<#import "../blocks/page.ftl" as p>

<@p.main "Статистика">
    <h4 class="text-center mb-4">Статистика выдачи учетных данных Литрес и Нон-фикшн за выбранный период</h4>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Начальная дата: </label>
            <div class="col-sm-4">
                <input type="date" name="startDate" class="form-control" id="startDate" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Конечная дата: </label>
            <div class="col-sm-4">
                <input type="date" name="endDate" class="form-control" id="endDate" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary mt-3">Считать</button>
    </form>

    <table class="table table-hover mt-5">
        <thead class="thead-light">
        <tr>
            <th scope="col">Филиал</th>
            <th scope="col">Литрес</th>
            <th scope="col">Нон-фикшн</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>Биц Бунина</td>
                <td>1, 23</td>
                <td></td>
            </tr>
            <tr>
                <td>БИЦ Смургиса</td>
                <td>3, 13</td>
                <td></td>
            </tr>
            <tr>
                <td>БИЦ Социальный</td>
                <td>4, 14</td>
                <td></td>
            </tr>
            <tr>
                <td>БИЦ Бартенева</td>
                <td>5, 15</td>
                <td></td>
            </tr>
            <tr>
                <td>БИЦ Семенова-Тян-Шанского</td>
                <td>6, 16</td>
                <td></td>
            </tr>
            <tr>
                <td>Биц нац. культур</td>
                <td>7, 20</td>
                <td></td>
            </tr>
            <tr>
                <td>БИЦ Рудничный</td>
                <td>9, 22</td>
                <td></td>
            </tr>
            <tr>
                <td>БИЦ Левобережный</td>
                <td>10, 24</td>
                <td></td>
            </tr>
            <tr>
                <td>БИЦ семейного чтения</td>
                <td>25, 18</td>
                <td></td>
            </tr>
            <tr>
                <td>ВИБ</td>
                <td>2</td>
                <td></td>
            </tr>
            <tr>
                <td>Б-ка "На Дачном"</td>
                <td>8</td>
                <td></td>
            </tr>
            <tr>
                <td>Б-ка "Сокольская"</td>
                <td>11</td>
                <td></td>
            </tr>
            <tr>
                <td>Б-ка "Солнечная"</td>
                <td>12</td>
                <td></td>
            </tr>
            <tr>
                <td>Б-ка "Матырская"</td>
                <td>17</td>
                <td></td>
            </tr>
            <tr>
                <td>Б-ка "Преображение"</td>
                <td>19</td>
                <td></td>
            </tr>
            <tr>
                <td>Б-ка "Эрудит"</td>
                <td>21</td>
                <td></td>
            </tr>
            <tr>
                <td>ЦГБ Есенина</td>
                <td>26</td>
                <td></td>
            </tr>
            <tr>
                <td>ЦГДБ Пришвина</td>
                <td>27</td>
                <td></td>
            </tr>
            <tr>
                <td>Итого:</td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</@p.main>