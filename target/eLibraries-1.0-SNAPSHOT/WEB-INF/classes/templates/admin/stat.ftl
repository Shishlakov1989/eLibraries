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
    <#if table??>
        <h4 class="mt-4">
            Количество аккаунтов Литрес и Нон-фикшн, выданных
            <#if startDate??>
                <#if endDate??>
                    с ${startDate} по ${endDate}
                <#else>
                    с ${startDate}
                </#if>
            <#elseif endDate??>
                по ${endDate}
            <#else>
                за все время
            </#if>
        </h4>

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
                <td>БИЦ Бунина</td>
                <td>${lr1} (взр)<br/>${lr23} (дет)</td>
                <td>${nf1} (взр)<br/>${nf23} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ Смургиса</td>
                <td>${lr3} (взр)<br/>${lr13} (дет)</td>
                <td>${nf3} (взр)<br/>${nf13} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ Социальный</td>
                <td>${lr4} (взр)<br/>${lr14} (дет)</td>
                <td>${nf4} (взр)<br/>${nf14} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ Бартенева</td>
                <td>${lr5} (взр)<br/>${lr15} (дет)</td>
                <td>${nf5} (взр)<br/>${nf15} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ Семенова-Тян-Шанского</td>
                <td>${lr6} (взр)<br/>${lr16} (дет)</td>
                <td>${nf6} (взр)<br/>${nf16} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ нац. культур</td>
                <td>${lr7} (взр)<br/>${lr20} (дет)</td>
                <td>${nf7} (взр)<br/>${nf20} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ Рудничный</td>
                <td>${lr9} (взр)<br/>${lr22} (дет)</td>
                <td>${nf9} (взр)<br/>${nf22} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ Левобережный</td>
                <td>${lr10} (взр)<br/>${lr24} (дет)</td>
                <td>${nf10} (взр)<br/>${nf24} (дет)</td>
            </tr>
            <tr>
                <td>БИЦ семейного чтения</td>
                <td>${lr25} (взр)<br/>${lr18} (дет)</td>
                <td>${nf25} (взр)<br/>${nf18} (дет)</td>
            </tr>
            <tr>
                <td>ВИБ</td>
                <td>${lr2}</td>
                <td>${nf2}</td>
            </tr>
            <tr>
                <td>Б-ка "На Дачном"</td>
                <td>${lr8}</td>
                <td>${nf8}</td>
            </tr>
            <tr>
                <td>Б-ка "Сокольская"</td>
                <td>${lr11}</td>
                <td>${nf11}</td>
            </tr>
            <tr>
                <td>Б-ка "Солнечная"</td>
                <td>${lr12}</td>
                <td>${nf12}</td>
            </tr>
            <tr>
                <td>Б-ка "Матырская"</td>
                <td>${lr17}</td>
                <td>${nf17}</td>
            </tr>
            <tr>
                <td>Б-ка "Преображение"</td>
                <td>${lr19}</td>
                <td>${nf19}</td>
            </tr>
            <tr>
                <td>Б-ка "Эрудит"</td>
                <td>${lr21}</td>
                <td>${nf21}</td>
            </tr>
            <tr>
                <td>ЦГБ Есенина</td>
                <td>${lr26}</td>
                <td>${nf26}</td>
            </tr>
            <tr>
                <td>ЦГДБ Пришвина</td>
                <td>${lr27}</td>
                <td>${nf27}</td>
            </tr>
            <tr>
                <td>Итого:</td>
                <td>${lrAll}</td>
                <td>${nfAll}</td>
            </tr>
            </tbody>
        </table>
    </#if>
</@p.main>