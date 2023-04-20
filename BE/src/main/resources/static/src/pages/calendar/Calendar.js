

const mainContainer = document.querySelector('#main-container');

const makeCalendar = (list, holList) => {
  let dom = '<tr>';
  // 달력 그리기
  let cnt = 0;
  for (let i = 0; i < list.length; i++) {
    if (parseInt(i / 7) === cnt) {
      dom += `<td class="pb-20 pl-20 border px-4 py-2">${list[i]}</td>`;
    } else {
      dom += `</tr><tr><td class="pb-20 pl-20 border px-4 py-2">${list[i]}</td>`;
      cnt++;
    }
  }
  dom += '</tr>'
  return dom;
}


async function getCalendarData(year, month) {
  let response;
  if (year === undefined || month === undefined) {
    response = await fetch(`http://localhost:8080/calendar`);
  } else {
    response = await fetch(`http://localhost:8080/calendar?year=${year}&month=${month}`);
  }
  return await response.json();
}


const makeCalDom = async () => {
  const rst = await getCalendarData(2023, 4);
  const calIdxList = rst.calRst;
  const holList = rst.holRst;
  const dom = makeCalendar(calIdxList, holList);
  mainContainer.innerHTML = dom;
}

export default makeCalDom;

