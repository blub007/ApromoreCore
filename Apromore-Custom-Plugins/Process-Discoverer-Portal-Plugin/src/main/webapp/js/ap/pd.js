 * %%
 * %%
 * Copyright (C) 2018 - 2020 The University of Melbourne.
 * %%
 * %%
(function() {

  /**
   * To force select ZK combo when the old and new values are the same
   */
  function handleComboitemClick(src) {
    return function(ev) {
      // if click on the already selected item
      if ($(ev.currentTarget).hasClass('z-comboitem-selected')) {
        // force onSelect
        setTimeout(function() {
          zk.Widget.$('$' + src).fire(
              'onForceSelect',
              {},
              {toServer: true},
          );
        }, 200);
      }
    }
  }

  function installComboitemHandlers() {
    $('.ap-pd-duration-selector .z-comboitem').click(
        handleComboitemClick('durationAggSelector'),
    );
    $('.ap-pd-freq-selector .z-comboitem').click(
        handleComboitemClick('frequencyAggSelector'),
    );
  }

  function swapOrdering() {
    $('.ap-pd-chart-bi-legend').toggleClass('reversed');
  }

  function toggleOptions() {
    // let options = $('.ap-pd-drawer')
    let options = $('[data-t=ap-pd-aux]');
    let height = options.height()
    let cy = $('#ap-pd-process-model');
    let up = $('[data-t=collapse]'); // $('.ap-pd-drawer-splitter .z-icon-caret-up');
    let down = $('[data-t=expand]'); // $('.ap-pd-drawer-splitter .z-icon-caret-down');
    if (options.is(':visible')) {
      down.show();
      up.hide();
      options.slideUp(300, function() {
        cy.css({top: '0px'});
        Ap.pd.resize();
      });
    } else {
      up.show();
      down.hide();
      options.slideDown(300, function() {
        cy.css({top: height + 'px'});
        Ap.pd.resize();
      });
    }
  }

  /**
   * Drawing pie chart
   *
   */

  const PIE_SIZE = 50;
  const PIE_R = PIE_SIZE / 2;
  const FULL_CIRCLE = Math.PI * PIE_R;

  // Drawing using dash-array method
  //
  // const SVG_TEMPLATE = `<svg height="${PIE_SIZE}" width="${PIE_SIZE}" viewBox="0 0 ${PIE_SIZE} ${PIE_SIZE}" >
  //   <circle r="${PIE_R}" cx="${PIE_R}" cy="${PIE_R}" fill="#D7DAE0" />
  //   <circle r="${PIE_R / 2}" cx="${PIE_R}" cy="${PIE_R}"
  //     fill="transparent"
  //     stroke="#afdaed"
  //     stroke-width="${PIE_R}"
  //     stroke-dasharray="${FULL_CIRCLE} ${FULL_CIRCLE}"
  //     transform="rotate(-90) translate(-${PIE_SIZE})"
  //   />
  // </svg>`;
  //
  // Ap.pd.genChart = function(chartType, percentage) {
  //   console.log(chartType, percentage)
  //   let id = `#ap-pd-chart-${chartType}`;
  //   let container = $(`${id}`);
  //   if (!$(`${id} svg`).length) {
  //     container.html(SVG_TEMPLATE);
  //   }
  //   let semiCircleRad = (percentage / 100) * FULL_CIRCLE;
  //   let circles = $(`${id} svg circle`);
  //   $(circles[1]).attr({'stroke-dasharray': `${semiCircleRad} ${FULL_CIRCLE}`});
  // };

  // Using path

  const SVG_TEMPLATE = `<svg height="${PIE_SIZE}" width="${PIE_SIZE}" viewBox="0 0 ${PIE_SIZE} ${PIE_SIZE}" >
    <circle r="${PIE_R}" cx="${PIE_R}" cy="${PIE_R}" fill="#D7DAE0" stroke-width="1" stroke="white" />
    <path
      stroke="white"
      fill="#afdaed"
      stroke-width="1"
    />
  </svg>`;

  function genChart(chartType, percentage) {
    let id = `#ap-pd-chart-${chartType}`;
    let container = $(`${id}`);
    if (!$(`${id} svg`).length) {
      container.html(SVG_TEMPLATE);
    }
    if (percentage > 99.9) { percentage = 99.9; }
    const percent = percentage / 100;
    const r = PIE_R;
    const a = 2 * Math.PI * percent;
    const x = r + r * Math.sin(a);
    const y = r - r * Math.cos(a);
    let lArc = percent > .5 ? 1 : 0;
    let path = [
      `M ${r} ${r}`,
      `L ${r} 0`,
      `A ${r} ${r} 0 ${lArc} 1 ${x} ${y}`,
      `Z`,
    ].join(' ');
    $(`${id} path`).attr({'d': path});
  };

  /**
   * Humanizing date, currently not used
   *
   * Example:
   *   const startTimeCls = '.ap-pd-start-time';
   *   const endTimeCls = '.ap-pd-end-time';
   *   humanizeDate(startTimeCls);
   *   humanizeDate(endTimeCls);
   */
  const parseFormat = 'DD.MM.YYYY HH:mm:ss';
  const displayFormat = 'D MMM YY, HH:mm';

  const humanizeDate = selector => {
    let originalDate = $(selector).text();
    $(selector).text(moment(originalDate, parseFormat).format(displayFormat)).attr('title', originalDate);
  };

  Object.assign(Ap.pd, {
    installComboitemHandlers,
    swapOrdering,
    toggleOptions,
    genChart,
  });

  zk.afterMount(function() {
    Ap.pd.init();
    setTimeout(function() {
      try {
        Ap.pd.installComboitemHandlers();
      } catch (e) {
        // pass
      }
    }, 1000);
    zAu.send(new zk.Event(zk.Widget.$('$win'), 'onLoaded'));
  });

})();


