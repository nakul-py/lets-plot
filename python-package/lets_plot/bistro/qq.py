#  Copyright (c) 2022. JetBrains s.r.o.
#  Use of this source code is governed by the MIT license that can be found in the LICENSE file.

from lets_plot.plot.core import PlotSpec

__all__ = ['qq_plot']


def qq_plot(data=None, sample=None, *, x=None, y=None,
            distribution=None, dparams=None, quantiles=None,
            group=None,
            show_legend=None,
            color=None, fill=None, alpha=None, size=None, shape=None,
            line_color=None, line_size=None, linetype=None) -> PlotSpec:
    return PlotSpec(data=data, mapping=None, scales=[], layers=[], bistro={
        'name': 'qqplot',
        'sample': sample,
        'x': x,
        'y': y,
        'distribution': distribution,
        'dparams': dparams,
        'quantiles': quantiles,
        'group': group,
        'show_legend': show_legend,
        'color': color,
        'fill': fill,
        'alpha': alpha,
        'size': size,
        'shape': shape,
        'line_color': line_color,
        'line_size': line_size,
        'linetype': linetype,
    })
