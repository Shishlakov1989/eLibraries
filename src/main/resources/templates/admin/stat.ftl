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
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Филиал: </label>
            <div class="col-sm-4">
                <input type="number" name="filial" class="form-control" id="filial" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary mt-3">Считать</button>
    </form>
</@p.main>