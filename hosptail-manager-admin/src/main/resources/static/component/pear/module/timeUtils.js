layui.define(['layer', 'jquery'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer;
    let timeUtils = {
        /**
         * 获取当前日期的开始事件
         * @param time
         * @returns {number}
         */
        startTime:function (time) {
            const nowTimeDate = new Date();
            return nowTimeDate.setHours(0, 0, 0, 0);
        },
        /**
         * 获取当前时间的结束时间
         * @param time
         */
        endTime:function (time) {
            const nowTimeDate = new Date();
            return nowTimeDate.setHours(23, 59, 59, 999);
        },
        /**
         * 获取本周的开始时间和结束时间
         * @param time
         * @returns {{startTime: Date, endTime: Date}}
         */
        getCurrentWeekStartTimeAndEndTime:function (time) {
            const current = time ? time : new Date();
            // current是本周的第几天
            let nowDayOfWeek = current.getDay();
            if (nowDayOfWeek === 0) nowDayOfWeek = 7;
            const dayNum = 1 * 24 * 60 * 60 * 1000;
            // 获取本周星期一的时间，星期一作为一周的第一天
            const firstDate = new Date(current.valueOf() - (nowDayOfWeek - 1) * dayNum);
            // 获取本周星期天的时间，星期天作为一周的最后一天
            const lastDate = new Date(new Date(firstDate).valueOf() + 6 * dayNum);
            return {
                startTime: new Date(startTime(firstDate)),
                endTime: new Date(endTime(lastDate)),
            };
        },
        /**
         * 获取本月的开始时间
         * @param time
         * @returns {number}
         */
        getCurrentMonthFirst:function (time) {
            const date = time ? time : new Date();
            date.setDate(1);
            return startTime(date);
        },
        /**
         * 获取本月的结束时间
         * @param time
         * @returns {*}
         */
        getCurrentMonthLast:function (time) {
            const date = time ? time : new Date();
            const currentMonth = date.getMonth();
            const nextMonth = currentMonth + 1;
            const nextMonthFirstDay = new Date(date.getFullYear(), nextMonth, 1);
            const oneDay = 24 * 60 * 60 * 1000;
            return endTime(new Date(nextMonthFirstDay - oneDay));
        },
        /**
         * 获取当年的第一天
         * @param date
         * @returns {number}
         */
        getCurrentYearFirst:function (date) {
            date = date ? date : new Date();
            date.setDate(1);
            date.setMonth(0);
            return startTime(date);
        },
        /**
         * 获取当年的最后一天
         * @param date
         * @returns {number}
         */
        getCurrentYearLast:function (date) {
            date = date ? date : new Date();
            date.setFullYear(date.getFullYear() + 1); // 设置到明年
            date.setMonth(0); // 明年的0月，也就是对应到1月，是存在的哦，不是不存在的0
            date.setDate(0); // 明年的0日
            return endTime(date);
        },
        /**
         * 获取本季度的开始时间
         * @returns {{startTime: Date, endTime: Date}}
         */
        getCurrentQuarter:function () {
            const today = new Date();
            const year = today.getFullYear();
            const month = today.getMonth() + 1;

            let quarter;
            if (month <= 3) {
                quarter = 1;
            } else if (month <= 6) {
                quarter = 2;
            } else if (month <= 9) {
                quarter = 3;
            } else {
                quarter = 4;
            }

            const quarterStartDate = new Date(year, (quarter - 1) * 3, 1);
            const quarterEndDate = new Date(year, quarter * 3, 0, 23, 59, 59, 999);

            return {
                startTime: quarterStartDate,
                endTime: quarterEndDate
            };
        }
    }

    exports('timeUtils', timeUtils);
})
