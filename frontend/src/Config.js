
export const serverUrl = 'http://localhost:8080/';

export const defaultProfileImgUrl = 'default_profile_img.jpg';

export const monthToName = monthNumber => [
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
][monthNumber - 1];

export const timestampToDate = timestamp => {
    let date = new Date(timestamp * 1000);
    let hours = ("0" + date.getHours()).substring(1, 3);
    let minutes = ("0" + date.getMinutes()).substring(1, 3);
    let seconds = ("0" + date.getSeconds()).substring(1, 3);
    let year = date.getUTCFullYear();
    let month = ("0" + (date.getMonth() + 1)).substring(1, 3);
    let day = ("0" + date.getDate()).substring(1, 3);
    let monthName = monthToName(month).substring(0, 3).toLowerCase();
    return `${year} ${monthName}. ${day}. ${hours}:${minutes}:${seconds}`;
};


