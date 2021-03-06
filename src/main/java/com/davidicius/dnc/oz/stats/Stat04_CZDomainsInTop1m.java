package com.davidicius.dnc.oz.stats;

import com.davidicius.dnc.oz.Domain;
import com.davidicius.dnc.oz.Stat;
import com.davidicius.dnc.oz.StatOz;
import com.davidicius.dnc.oz.StatsContext;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Stat04_CZDomainsInTop1m implements Stat {
    public void printStat(StatsContext ctx,  BufferedWriter out) throws IOException {
        out.write("04 - CZ domeny mezi TOP svetovymi domenami");
        out.newLine();

        int top1m = 0;
        int all = 0;
        for (Domain d : ctx.getDomains()) {
            String name = d.getName().toLowerCase();
            if (d.isTop1m() && name.endsWith(".cz")) top1m++;
            all++;
        }

        out.write(String.format("%s\t%s", "CZ - domeny", "NON CZ - domeny"));
        out.newLine();

        out.write(String.format("%d\t%d", top1m, all - top1m));
        out.newLine();
    }

    public int priority() {
        return 0;
    }
}
